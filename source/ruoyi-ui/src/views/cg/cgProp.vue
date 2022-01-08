<template>
  <el-container>
    <el-main>
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
            <el-tab-pane v-for="(group,index) in getGroupList" :key="group.groupCode" :label="group.groupName" :name="index+''">
                <el-row :gutter="10">
                  <el-form :model="formData"   ref="form" :inline="false" label-width="150px">
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
                              <el-input type="textarea" v-else-if="domainUtil.isTextarea(prop)" v-model="formData[prop.propCode]" 
                              :disabled="propDisabled(prop.propCode)"
                              />
                              <el-input v-else v-model="formData[prop.propCode]" 
                              :disabled="propDisabled(prop.propCode)"
                              />
                              <el-button icon="el-icon-edit" circle @click="handleIconClick(prop.propCode)" v-show="isEditShow(prop.propCode)" :disabled="false"></el-button>
                              <el-button icon="el-icon-brush" type="warning" circle @click="handleResetClick(prop.propCode)"  v-show="isResetShow(prop.propCode)" :disabled="false"></el-button>
                              <el-button icon="el-icon-circle-check" type="success" circle @click="handleIconSaveClick(prop.propCode)"  v-show="isSaveShow(prop.propCode)" :disabled="false"></el-button>
                              <!-- {{prop.propCode}}-{{propReadOnly[prop.propCode]}}-{{propReadOnly}} -->
                          </template>
                          <template v-else>
                              <el-select  v-if="isShowDefaultValueSelect"  v-model="formData[prop.propCode]" placeholder="请选择" 
                                  @change="handleSelectChange"
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
  },
  data() {
    return {
        activeName:"0",
        tabMetaData:[],
        extendProp:{
        },
        dropdownMap:{
        },
        // defaultDropName:"",//默认值下拉名称
        defaultDropList:[],//默认值下拉列表
        propReadOnly:{},
        privatePropSet:new Set(),
        privateEditShowSet:new Set(),
    };
  },
  watch: {
    formData(newVal){
      this.$emit("input",newVal);
    }
  },
  computed:{
    isWarningShow(){
      return function (propCode){
        return !this.propDisabled(propCode);
      }
    },
    isLockShow(){
      return function (propCode){
        if(!this.disabled){
          return false;
        }
        return !this.privatePropSet.has(propCode);
      } 
    },
    isInfoShow(){
      return function (propCode){
        return true;
      } 
    },
    isEditShow(){
       return function (propCode){
        // console.log("EditShow:"+propCode);
        if(!this.disabled){
          return false;
        }
        return !this.privatePropSet.has(propCode);
      } 
    },
    isResetShow(){
      return function (propCode){
        if(!this.disabled){
          return false;
        }
        return this.privatePropSet.has(propCode);
      } 
    },
    isSaveShow(){
       return function (propCode){
        if(!this.disabled){
          return false;
        }
        return this.privatePropSet.has(propCode);
      } 
    },
    propDisabled(){
      return function(propCode){
        return this.propReadOnly[propCode]==undefined||this.propReadOnly[propCode]==null?true:this.propReadOnly[propCode]
      }
    },
    formData(){
      return this.value;
    },
    isShowDefaultValueSelect(){
      // console.log("isShowDefaultValueSelect");
      return this.formData["SELECT_DROP_NAME"]!=null&&this.formData["SELECT_DROP_NAME"]!="";
    },
    defaultDropName(){
      if(this.formData["SELECT_DROP_NAME"]==undefined||this.formData["SELECT_DROP_NAME"]==null){
        return "";
      }
      return this.formData["SELECT_DROP_NAME"];
    },    
    getGroupList(){
      // let arr = this.extendProp.relPropGroup;
      // if(arr==null||arr.length==0){
      //   return [{
      //     groupCode:"-1",
      //     groupName:"属性"
      //   }]
      // }
      if(this.extendProp==null){
        return [];
      }
      if(this.extendProp.relPropGroup==null){
        return []
      }
      let arr = this.extendProp.relPropGroup;
      let arrCopy = JSON.parse(JSON.stringify(arr));
      // console.log(arrCopy);
      return arrCopy.sort((n1,n2)=>{
        return n1.sort-n2.sort;
      })
    },
  },
  watch:{
    defaultDropName(newVal,oldVal){
      if(this.defaultDropName==undefined||this.defaultDropName==null||this.defaultDropName==""){
        return;
      }
      this.getDrop(this.defaultDropName).then(response=>{
        this.defaultDropList = response.parameterMap.data;
      })
    },
    privatePropSet(newVal,oldVal){

    }

  },
  created() {
    getAllExtendProp("918554647633854403").then(response=>{
      //console.log(response);
      this.extendProp = response.parameterMap.data;
      this.getAllDict();
    })
  },
  methods: {
    handleResetClick(propCode){
      this.privatePropSet.delete(propCode);

      let data = {

      }
      deleteFieldPrivateProp()
    },
    handleIconSaveClick(propCode){

    },
    handleIconClick(propCode){
      // console.log(propCode);
      this.privatePropSet.add(propCode);
      this.$set(this.propReadOnly,propCode,false);
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
      // if(groupCode==-1){
      //   if(this.extendProp.relPropList!=null){
      //     return this.extendProp.relPropList.sort((n1,n2)=>{
      //       console.log("---------------------------------");
      //       console.log(n1);
      //       //console.log(n1.sort,n2.sort);
      //       return n1.sort-n2.sort;
      //     });
      //   }
      // }
      let arr  = this.extendProp.relPropMap[groupCode];
      let arrCopy = JSON.parse(JSON.stringify(arr));
      // console.log(arrCopy);
      return arrCopy.sort((n1,n2)=>{
        return n1.sort-n2.sort;
      })
    },

    handleSelectChange(newVal){
      if(newVal==null){
        this.isShowDefaultValueSelect = false;
      }
      else{
        this.isShowDefaultValueSelect = true;
        this.defaultDropName = newVal;
      }
    },
    handleClick(){

    },
  }
};
</script>