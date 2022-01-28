<template>
  <el-container>
    <el-main>
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
            <el-tab-pane v-for="(group,index) in getGroupList" :key="group.groupCode" :label="group.groupName" :name="index+''">
                <el-row :gutter="10">
                  <el-form :model="formData"   ref="form" :inline="true" label-width="150px" class="demo-dynamic">
                    <template>
                      <el-form-item v-for="prop in getPropListByGroupCode(group.groupCode)" :key="prop.id" :label="prop.propName" :prop="prop.propCode">
                          <span slot="label">
                            <el-tooltip :content="prop.remark" placement="top">
                              <span>
                                <i class="el-icon-lock"  v-show="isLockShow(prop.propCode)"></i>
                                <i class="el-icon-warning" style="color:orange;" v-show="isWarningShow(prop.propCode)"></i>
                                <i class="el-icon-question" v-show="isInfoShow(prop.propCode)"></i>
                              </span>
                            </el-tooltip>
                            {{prop.propName}}
                          </span>
                          <template v-if="!domainUtil.isDefaultValueProp(prop)">
                              <el-select  v-if="domainUtil.isSelect(prop)"  v-model="formData[prop.propCode]" placeholder="请选择" 
                                  @change="handleSelectChange"
                                  :disabled="propDisabled(prop.propCode)"
                                  clearable>
                                  <el-option
                                  v-for="item in dropdownMap[domainUtil.getDropName(prop)]"
                                  :key="item.value"
                                  :label="item.label"
                                  :value="item.value">
                                  </el-option>
                              </el-select>
                              <el-input type="textarea" v-else-if="domainUtil.isTextarea(prop)"  :ref="prop.propCode+'_input'"
                              :disabled="propDisabled(prop.propCode)" :value="formData[prop.propCode]" 
                              @input="val=>handleInput(val,prop.propCode)"
                              />
                              <el-input v-else :value="formData[prop.propCode]" :ref="prop.propCode+'_input'"
                              @input="val=>handleInput(val,prop.propCode)"
                              :disabled="propDisabled(prop.propCode)"
                              />
                              123
                              <el-button icon="el-icon-edit" circle @click="handleIconClick(prop.propCode)" v-show="isEditShow(prop.propCode)" :disabled="false"></el-button>
                              <el-button icon="el-icon-brush" type="warning" circle @click="handleResetClick(prop.propCode)"  v-show="isResetShow(prop.propCode)" :disabled="false"></el-button>
                              <el-button icon="el-icon-circle-check" type="success" circle @click="handleIconSaveClick(prop.propCode)"  v-show="isSaveShow(prop.propCode)" :disabled="false"></el-button>
                              <!-- {{prop.propCode}}-{{propReadOnly[prop.propCode]}}-{{propReadOnly}} -->
                          </template>
                          <!-- 如果是默认下拉 -->
                          <template v-else>
                            <el-col :span="24">
                                <el-select  v-if="isShowDefaultValueSelect"  v-model="formData[prop.propCode]" placeholder="请选择" 
                                    :disabled="propDisabled(prop.propCode)"
                                    clearable>
                                    <el-option
                                    v-for="item in defaultDropList"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                    </el-option>
                                </el-select>
                                <el-input v-else v-model="formData[prop.propCode]" 
                                :disabled="propDisabled(prop.propCode)"
                                />
                                <el-button icon="el-icon-edit" circle @click="handleIconClick(prop.propCode)" v-show="isEditShow(prop.propCode)" :disabled="false"></el-button>
                                <el-button icon="el-icon-brush" type="warning" circle @click="handleResetClick(prop.propCode)"  v-show="isResetShow(prop.propCode)" :disabled="false"></el-button>
                                <el-button icon="el-icon-circle-check" type="success" circle @click="handleIconSaveClick(prop.propCode)"  v-show="isSaveShow(prop.propCode)" :disabled="false"></el-button>
                            </el-col>
                          </template>
                      </el-form-item>
                    </template>
                  </el-form>
                </el-row>
            </el-tab-pane>
            <!-- <el-tab-pane v-for="group in getGroupList()" >
              {{group}}
            </el-tab-pane> -->
        </el-tabs>
    </el-main>
  </el-container>
</template>

<script>

import {getAllExtendProp,getComMetaByComCode} from "@/api/cg/com"

export default {
  name: "cgprop",
  props: {
    value:Object,
    disabled:Boolean,
    privatePropObject:Object
  },
  data() {
    return {
        activeName:"0",
        tabMetaData:[],
        extendProp:{
        },
        dropdownMap:{
        },
        defaultDropList:[],//默认值下拉列表
        propReadOnly:{},
        privateEditShowSet:new Map(),
        isRunComputed:false,
        defaultDropName:"",
        // formData:{}
    };
  },
  watch: {
    formData(newVal){
      this.$emit("input",newVal);
      //console.log("formData.change");
    },
    value(newVal){
      this.formData = newVal;
    },
  },
  computed:{
    isWarningShow(){
      return function (propCode){
        //this.isRunComputed ="1";
        return !this.propDisabled(propCode);
      }
    },
    isLockShow(){
      return function (propCode){
        //this.isRunComputed ="1";
        if(!this.disabled){
          return false;
        }
        return !this.privatePropObject[propCode]=="1";
      } 
    },
    isInfoShow(){
      return function (propCode){
        //this.isRunComputed ="1";
        return true;
      } 
    },
    isEditShow(){
       return function (propCode){
         //this.isRunComputed ="1";
        console.log("EditShow:"+propCode);
        if(!this.disabled){
          return false;
        }
        return !this.privatePropObject[propCode]=="1";
      } 
    },
    isResetShow(){
      return function (propCode){
        //this.isRunComputed ="1";
        console.log("isResetShow:"+propCode);
        if(!this.disabled){
          return false;
        }
        return this.privatePropObject[propCode]=="1";
      } 
    },
    isSaveShow(){
       return function (propCode){
        //this.isRunComputed ="1";
        if(!this.disabled){
          return false;
        }
        return this.privatePropObject[propCode]=="1";
      } 
    },
    propDisabled(){
      return function(propCode){
        //this.isRunComputed ="1";
        if(!this.disabled){
          return false;
        }
        return !this.privatePropObject[propCode]=="1";
      }
    },

    isShowDefaultValueSelect(){
      return this.formData["SELECT_DROP_NAME"]!=null&&this.formData["SELECT_DROP_NAME"]!="";
    },
    // defaultDropName(){
    //   if(this.formData["SELECT_DROP_NAME"]==undefined||this.formData["SELECT_DROP_NAME"]==null){
    //     return "";
    //   }
    //   return this.formData["SELECT_DROP_NAME"];
    // },    
    getGroupList(){
      if(this.extendProp==null){
        return [];
      }
      if(this.extendProp.relPropGroup==null){
        return []
      }
      let arr = this.extendProp.relPropGroup;
      let arrCopy = JSON.parse(JSON.stringify(arr));
      return arrCopy.sort((n1,n2)=>{
        return n1.sort-n2.sort;
      })
    },
    formData(){
      return this.value;
    }
  },
  watch:{
    defaultDropName(newVal,oldVal){
      console.log("defaultDropName(newVal,oldVal)");
      if(newVal==undefined||newVal==null||newVal==""){
        return;
      }
      this.getDrop(newVal).then(response=>{
        this.defaultDropList = response.parameterMap.data;
        console.log("this.defaultDropList");
        console.log(this.defaultDropList);
      })
    },
    privatePropObject(newVal,oldVal){
      this.value.privatePropObject = newVal;
    }

  },
  created() {
    getAllExtendProp("918554647633854403").then(response=>{
      this.extendProp = response.parameterMap.data;
      this.getAllDict();
    })
  },
  methods: {
    handleResetClick(propCode){
      this.$delete(this.privatePropObject,propCode);
      //this.isRunComputed ="3";
      console.log("this.delete(this.privatePropObject,propCode);");
    },
    handleIconSaveClick(propCode){

    },
    handleIconClick(propCode){
      this.$set(this.propReadOnly,propCode,false);
      this.$set(this.privatePropObject,propCode,"1");
    },
    getAllDict(){
      this.extendProp.relPropList.forEach(item=>{
        const dropName = this.domainUtil.getDropName(item);
        if(dropName!=""){
          if(this.dropdownMap[dropName]==null){
            this.getDrop(dropName).then(response=>{
              this.dropdownMap[dropName] = response.parameterMap.data;
            })
          }
        }
      })
    },
    getPropList(){
      return this.extendProp.relPropList;
    },
    getPropListByGroupCode(groupCode){
      let arr  = this.extendProp.relPropMap[groupCode];
      let arrCopy = JSON.parse(JSON.stringify(arr));
      return arrCopy.sort((n1,n2)=>{
        return n1.sort-n2.sort;
      })
    },

    handleSelectChange(newVal){
      
      if(newVal==null){
        //this.isShowDefaultValueSelect = false;
      }
      else{
        //this.isShowDefaultValueSelect = true;
        this.defaultDropName = newVal;
      }
      console.log("handleSelectChange:"+newVal);
    },
    handleClick(){

    },
    handleInput(value,prop){
      // let val = this.value;
      // val[prop]=value;
      let formData = this.formData;
      formData[prop]=value;
      let cp = JSON.parse(JSON.stringify(formData));
      // this.$set(this.formData,prop,value)
      this.$emit("input",cp)
      console.log(cp);
      // console.log(this.$refs);
      // console.log(this.$refs.form);
      // console.log(this.$refs[refName]);
    },
  }
};
</script>