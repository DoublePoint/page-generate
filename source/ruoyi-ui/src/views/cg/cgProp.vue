<template>
  <el-container>
    <el-main>
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
            <el-tab-pane v-for="(group,index) in getGroupList()" :key="group.groupCode" :label="group.groupName" :name="index">
                <el-row :gutter="10">
                  <el-form :model="formData" :disabled="disabled" ref="form" :inline="false" label-width="150px">
                      <el-form-item v-for="prop in getPropListByGroupCode(group.groupCode)" :key="prop.id" :label="prop.propName" :prop="prop.propCode">
                          <span slot="label">
                            <el-tooltip :content="prop.remark" placement="top">
                              <i class="el-icon-question"></i>
                            </el-tooltip>
                            {{prop.propName}}
                          </span>
                          <el-select  v-if="domainUtil.isSelect(prop)"  v-model="formData[prop.propCode]" placeholder="请选择" 
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
                      </el-form-item>
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
    }
  },
  watch:{
    
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
      console.log(this.extendProp.relPropMap[groupCode]);
      return this.extendProp.relPropMap[groupCode];
    },
    getGroupList(){
      return this.extendProp.relPropGroup;
    },
    
    handleClick(){

    },
  }
};
</script>