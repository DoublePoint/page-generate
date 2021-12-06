<template>
  <el-container>
    <el-main>
      <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick" >
            <el-tab-pane label="字段属性" name="first">
                <el-row :gutter="10">
                  <el-form :model="formData" ref="form" :inline="false" label-width="150px">
                      <el-form-item v-for="prop in getPropList()" :key="prop.id" :label="prop.propName" :prop="prop.propName">
                        <el-select  v-if="isSelect(prop)"  v-model="formData[prop.propName]" placeholder="请选择">
                            <el-option
                            v-for="item in dropdownMap[getDropName(prop)]"
                            :key="item.dictValue"
                            :label="item.dictLabel"
                            :value="item.dictValue">
                            </el-option>
                        </el-select>
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
// import { getDomain,saveDomainObject,createNewDomain } from "@/api/cg/domain.js";

export default {
  name: "cgprop",
  props: ['value'],
  data() {
    return {
        activeName:"first",
        
        formMetaData:{
            
        },
        domType:"",
        tabMetaData:[],
        options:[],
        extendProp:{

        },
        dropdownMap:{

        }
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
      this.getAllDrop();
    })
    // getDomain("BASE").then(response=>{
    //   this.extendProp = response.parameterMap.data;
    // })
    // this.getDicts("sys_yes_no").then(response => {
    //   this.options = response.data;
    // });
    
  },
  methods: {
    getAllDrop(){
      this.extendProp.relPropList.forEach(item=>{
        const dropName = this.getDropName(item);
        console.log(dropName);
        if(dropName!=""){
          this.getDicts(dropName).then(response=>{
            this.dropdownMap[dropName] = response.data;
          })
        }
      })
    },
    getPropList(){
      return this.extendProp.relPropList;
    },
    getDropName(prop){
      return this.pGetFieldObjPro(prop,'dropname');
    },
    getFieldLabel(prop){
      return this.pGetFieldObjPro(prop,'label');
    },
    getDomType(prop){
      return this.pGetFieldObjPro(prop,'domtype');
    },
    pGetFieldObjPro(prop,propName){
      if(prop.relDomain==null){
        console.log(`ID:${prop.id}的prop.relDomain为空.`);
        return ''
      }
      if(prop.relDomain.relObjectProp==null){
        console.log(`ID:${prop.id}的prop.relDomain.relObjectProp为空`);
        return ''
      }
      if(prop.relDomain.relObjectProp[propName]==null){
        console.log(`ID:${prop.id}的prop.relDomain.relObjectProp.${propName}为空`);
        return ''
      }
      return prop.relDomain.relObjectProp[propName].propValue;
    },
    isSelect(prop){
      return this.getDomType(prop,"domtype")=="03";
    },
   handleClick(){

   },
   clearMeta(){
     this.formMetaData = null;
     this.tabMetaData = null;
   },
  //  initAllCom(){
  //    if(this.comCode==null){
  //      return;
  //    }
  //    getComMetaByComCode(this.comCode).then(res=>{
  //       // console.log(res);
  //       const data = res.parameterMap.data;
  //       this.formMetaData = data.relProp;
  //       this.tabMetaData = data.relPropGroup;
  //     })
  //  },
   getSelectData(dictname){
     this.getDicts(dictname).then(response => {
      this.$set(this.dropdownMap, dictname, response.data)
      console.log(this.dropdownMap)
    });
   }
  }
};
</script>