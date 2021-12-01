<template>
  <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
        <el-tab-pane label="字段属性" name="first">
            <el-form :model="tableFieldForm" ref="tableFieldForm" :inline="false" label-width="150px">
                <el-form-item label="字段编码" prop="propName">
                    <el-input v-model="tableFieldForm.propName" />
                </el-form-item>
                <el-form-item label="排序" prop="sort">
                    <el-input v-model="tableFieldForm.sort" />
                </el-form-item>
                <el-form-item label="下拉名称" prop="dropName">
                    <el-select v-model="tableFieldForm.dropName" placeholder="请选择">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
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

import {getBaseProp} from "@/api/cg/baseprop"

export default {
  name: "cgprop",
  data() {
    return {
        activeName:"first",
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        tableFieldForm:{
            tableCode:"",
            propCode:"",
            propName:"",
            dropName:"",
            sort:0,
        },
    };
  },
  watch: {
   
  },
  created() {
      getBaseProp().then(res=>{
          const data = res.data;
          console.log(data);
      })
  },
  methods: {
   handleClick(){

   }
  }
};
</script>