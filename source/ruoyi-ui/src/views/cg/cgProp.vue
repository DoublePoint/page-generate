<template>
  <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
        <el-tab-pane label="字段属性" name="first">
            <!-- <el-form :model="formData" ref="formData" :inline="false" label-width="150px">
                <el-form-item label="字段编码" prop="propName">
                    <el-input v-model="formData.propName" />
                </el-form-item>
                <el-form-item label="排序" prop="sort">
                    <el-input v-model="formData.sort" />
                </el-form-item>
                <el-form-item label="下拉名称" prop="dropName">
                    <el-select v-model="formData.dropName" placeholder="请选择">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form> -->
            <el-row :gutter="10">
                Com Code:{{comCode}}
            </el-row>
            <el-row :gutter="10">
              <el-form :model="formData" ref="form" :inline="false" label-width="150px">
                  <!-- <el-form-item :label="selProp.propName" :prop="selProp.propCode">
                      <el-select v-model="domType" placeholder="请选择">
                          <el-option
                          v-for="item in domTypeList"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                          </el-option>
                      </el-select>
                  </el-form-item> -->
                  
                  <el-form-item v-for="selProp in formMetaData['base']" :key="selProp.id" :label="selProp.propName" :prop="selProp.propCode">
                      <el-input v-model="formData[selProp.propCode]" />
                  </el-form-item>
              </el-form>
            </el-row>
        </el-tab-pane>
        <el-tab-pane v-for="group in tabMetaData" :key="group.groupCode" :label="group.groupName" :name="group.groupCode">
          {{group}}
        </el-tab-pane>
    </el-tabs>
</template>

<script>

import {getInput,getComMetaByComCode} from "@/api/cg/com"

export default {
  name: "cgprop",
  props: ['value','comCode'],
  data() {
    return {
        activeName:"first",
        formData:this.value,
        formMetaData:{
            
        },
        domType:"",
        tabMetaData:[]
    };
  },
  watch: {
    formData(newVal){
      this.$emit("input",newVal);
    }
  },
  watch:{
    comCode(newVal){
      this.initAllCom();
    }
  },
  created() {
      if(this.comCode==null){
        return;
      }
      
  },
  methods: {
   handleClick(){

   },
   clearMeta(){
     this.formMetaData = null;
     this.tabMetaData = null;
   },
   initAllCom(){
     if(this.comCode==null){
       return;
     }
     getComMetaByComCode(this.comCode).then(res=>{
        console.log(res);
        const data = res.parameterMap.metaCom;
        this.formMetaData = data.relProp;
        this.tabMetaData = data.relPropGroup;
      })
   }
  }
};
</script>