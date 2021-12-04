<template>
  <el-container>
    <el-main>
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
                <!-- <el-row :gutter="10">
                    Com Code:{{comCode}}
                </el-row> -->
                <el-row :gutter="10">
                  <el-form :model="formData" ref="form" :inline="false" label-width="150px">
                      <!-- <el-form-item :label="subDomain.propName" :prop="subDomain.propCode">
                          <el-select v-model="domType" placeholder="请选择">
                              <el-option
                              v-for="item in domTypeList"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                              </el-option>
                          </el-select>
                      </el-form-item> -->
                      
                      <!-- <el-form-item v-for="subDomain in formMetaData['base']" :key="subDomain.id" :label="subDomain.propName" :prop="subDomain.propCode">
                          <el-input v-model="formData[subDomain.propCode]" />
                      </el-form-item> -->
                      <template v-if="domainProp!=null&&domainProp.relDomainMap!=null">
                        <el-form-item v-for="subDomain in domainProp.relDomainMap['base']" :key="subDomain.id" :label="subDomain.domainName" :prop="subDomain.domainCode">
                          <el-select  v-if="subDomain.relMetaCom.domType=='03'"  v-model="formData.propMap[subDomain.domainCode]" placeholder="请选择">
                              <el-option
                              v-for="item in dropdownMap[subDomain.relObjectProp.dropname.propValue]"
                              :key="item.dictValue"
                              :label="item.dictLabel"
                              :value="item.dictValue">
                              </el-option>
                              <template>
                                {{subDomain.relObjectProp.dropname.propValue}}{{getSelectData(subDomain.relObjectProp.dropname.propValue)}} 
                              </template>
                          </el-select>
                          <el-input v-else v-model="formData.propMap[subDomain.domainCode]" />
                          
                        </el-form-item>
                      </template>
                  </el-form>
                </el-row>
            </el-tab-pane>
            <el-tab-pane v-for="group in tabMetaData" :key="group.groupCode" :label="group.groupName" :name="group.groupCode">
              {{group}}
            </el-tab-pane>
        </el-tabs>
    </el-main>
    <el-footer>
       
    </el-footer>
  </el-container>

</template>

<script>

import {getInput,getComMetaByComCode} from "@/api/cg/com"
import {getBaseProp} from "@/api/cg/baseprop.js"

export default {
  name: "cgprop",
  props: ['value','comCode','domainProp'],
  data() {
    return {
        activeName:"first",
        
        formMetaData:{
            
        },
        domType:"",
        tabMetaData:[],
        // domainProp:{
        //   relDomainMap:{
        //     base:[]
        //   }
        // },
        options:[],
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
    comCode(newVal){
      this.initAllCom();
    }
  },
  created() {
    // this.getBaseDomain();
    this.getDicts("sys_yes_no").then(response => {
      this.options = response.data;
    });
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
        // console.log(res);
        const data = res.parameterMap.metaCom;
        this.formMetaData = data.relProp;
        this.tabMetaData = data.relPropGroup;
      })
   },
   getSelectData(dictname){
     this.getDicts(dictname).then(response => {
      this.$set(this.dropdownMap, dictname, response.data)
      console.log(this.dropdownMap)
    });
   }
  //  getBaseDomain(){
  //    getBaseProp().then(response=>{
  //      this.baseProp = response.parameterMap.data;
  //      console.log(this.baseProp);
  //    })
  //  }
  }
};
</script>