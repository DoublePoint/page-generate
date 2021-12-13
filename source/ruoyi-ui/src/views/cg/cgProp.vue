<template>
  <el-container>
    <el-main>
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
            <el-tab-pane v-for="(group,index) in getGroupList()" :key="group.groupCode" :label="group.groupName" :name="index+''">
                <el-row :gutter="10">
                  <el-form :model="formData" :disabled="disabled" ref="form" :inline="false" label-width="150px">
                    <template>
                      <el-form-item v-for="prop in getPropListByGroupCode(group.groupCode)" :key="prop.id" :label="prop.propName" :prop="prop.propCode">
                          <span slot="label">
                            <el-tooltip :content="prop.remark" placement="top">
                              <i class="el-icon-question"></i>
                            </el-tooltip>
                            {{prop.propName}}
                          </span>
                          <template v-if="!domainUtil.isDefaultValueProp(prop)">
                              <el-select  v-if="domainUtil.isSelect(prop)"  v-model="formData[prop.propCode]" placeholder="请选择" 
                                  @change="handleSelectChange"
                                  clearable>
                                  <el-option
                                  v-for="item in dropdownMap[domainUtil.getDropName(prop)]"
                                  :key="item.value"
                                  :label="item.label"
                                  :value="item.value">
                                  </el-option>
                              </el-select>
                              <el-input type="textarea" v-else-if="domainUtil.isTextarea(prop)" v-model="formData[prop.propCode]" />
                              <el-input v-else v-model="formData[prop.propCode]" />
                          </template>
                          <template v-else>
                              <el-select  v-if="isShowDefaultValueSelect"  v-model="formData[prop.propCode]" placeholder="请选择" 
                                  @change="handleSelectChange"
                                  clearable>
                                  <el-option
                                  v-for="item in defaultDropList"
                                  :key="item.value"
                                  :label="item.label"
                                  :value="item.value">
                                  </el-option>
                              </el-select>
                              <el-input v-else v-model="formData[prop.propCode]" />
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
    };
  },
  watch: {
    formData(newVal){
      this.$emit("input",newVal);
    }
  },
  computed:{
    formData(){
      return this.value;
    },
    isShowDefaultValueSelect(){
      console.log("isShowDefaultValueSelect");
      return this.formData["SELECT_DROP_NAME"]!=null&&this.formData["SELECT_DROP_NAME"]!="";
    },
    defaultDropName(){
      if(this.formData["SELECT_DROP_NAME"]==undefined||this.formData["SELECT_DROP_NAME"]==null){
        return "";
      }
      return this.formData["SELECT_DROP_NAME"];
    }
  },
  watch:{
    defaultDropName(newVal,oldVal){
      if(this.defaultDropName==undefined||this.defaultDropName==null||this.defaultDropName==""){
        return;
      }
      this.getDrop(this.defaultDropName).then(response=>{
        this.defaultDropList = response.parameterMap.data;
      })
    }
  },
  created() {
    getAllExtendProp("4").then(response=>{
      console.log(response);
      this.extendProp = response.parameterMap.data;
      this.getAllDict();
    })
  },
  methods: {
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
      if(groupCode==-1){
        return this.extendProp.relPropList;
      }
      console.log(this.extendProp.relPropMap[groupCode]);
      return this.extendProp.relPropMap[groupCode];
    },
    getGroupList(){
      let arr = this.extendProp.relPropGroup;
      if(arr==null||arr.length==0){
        return [{
          groupCode:"-1",
          groupName:"属性"
        }]
      }
      return this.extendProp.relPropGroup;
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