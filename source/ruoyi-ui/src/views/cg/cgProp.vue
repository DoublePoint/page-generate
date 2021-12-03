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
            <el-form :model="formData" ref="form" :inline="false" label-width="150px">
                <el-form-item v-for="selProp in formMetaData.comPropList" :key="selProp.id" :label="selProp.propName" :prop="selProp.propCode">
                    <el-input v-model="formData[selProp.propCode]" />
                </el-form-item>
            </el-form>
        </el-tab-pane>
        <el-tab-pane label="基础属性" name="second">

        </el-tab-pane>
        <el-tab-pane label="逻辑属性" name="third">

        </el-tab-pane>
        <el-tab-pane label="其它属性" name="fourth">

        </el-tab-pane>
    </el-tabs>
</template>

<script>

import {getInput} from "@/api/cg/inputform"

export default {
  name: "cgprop",
  props: ['value'],
  data() {
    return {
        activeName:"first",
        formData:this.value,
        formMetaData:{
            
        }
    };
  },
  watch: {
    formData(newVal){
      this.$emit("input",newVal);
    }
  },
  created() {
      getInput(4).then(res=>{
        console.log(res);
        this.formMetaData = res.parameterMap.metaCom;
      })
  },
  methods: {
   handleClick(){

   }
  }
};
</script>