<template>
  <el-container>
    <el-main>
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
            <el-tab-pane label="字段属性" name="first">
                <el-row :gutter="10">
                  <el-form :model="formData" ref="form" :inline="false" label-width="150px">
                      <el-form-item v-for="prop in getPropList()" :key="prop.id" :label="prop.propName" :prop="prop.propName">
                          <span slot="label">
                            <el-tooltip :content="prop.remark" placement="top">
                              <i class="el-icon-question"></i>
                            </el-tooltip>
                            {{prop.propName}}
                          </span>
                          <el-select  v-if="domainUtil.isSelect(prop)"  v-model="formData[prop.propName]" placeholder="请选择"
                              clearable>
                              <el-option
                              v-for="item in dropdownMap[domainUtil.getDropName(prop)]"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                              </el-option>
                          </el-select>
                          <el-input type="textarea" v-else-if="domainUtil.isTextarea(prop)" v-model="formData[prop.propName]" />
                          <el-input v-else v-model="formData[prop.propName]" />
                      </el-form-item>
                  </el-form>
                </el-row>
            </el-tab-pane>
            <el-tab-pane v-for="group in tabMetaData" :key="group.groupCode" :label="group.groupName" :name="group.groupCode">
              {{group}}
            </el-tab-pane>
        </el-tabs>
    </el-main>
  </el-container>
</template>

<script>

import {getAllExtendProp,getComMetaByComCode} from "@/api/cg/com"

export default {
  name: "cgprop",
  props: ['value'],
  data() {
    return {
        activeName:"first",
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
    
    handleClick(){

    },
  }
};
</script>