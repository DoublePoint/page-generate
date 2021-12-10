<template>
  <div class="app-container">
    <!-- <el-row :gutter="20">
      <el-select v-model="tableId" placeholder="请选择">
        <el-option
          v-for="item in tableSelectList"
          :key="item.id"
          :label="item.tableCode"
          :value="item.id">
        </el-option>
      </el-select>
    </el-row> -->
    <el-row :gutter="20">
      <!--用户数据-->
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="150px">
            <template v-if="fieldMetaList!=null">
              <el-form-item v-for="field in fieldMetaList" :key="field.id" :label="domainUtil.getFieldLabel(field)" :prop="field.propCode">
                <el-select  v-if="domainUtil.isSelect(field)"  v-model="queryParams[field.propCode]" placeholder="请选择">
                    <el-option
                    v-for="item in dropdownMap[domainUtil.getDropName(field)]"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-input v-else v-model="queryParams[field.propCode]" />
              </el-form-item>
            </template>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="submitForm">确 定</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="cancel">取 消</el-button>
            </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
            <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['system:role:add']">新增</el-button>
        </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-table :data="tableDataList" stripe border>
          <el-table-column type="selection" width="50" align="center"  />
          <template v-for="field in fieldMetaList" >
              <template  v-if="domainUtil.isSelect(field)" >
                <el-table-column :label="domainUtil.getFieldLabel(field)" :key="field.id"  align="center" :width="domainUtil.getWidth(field)" :prop="field.propCode"
                  sortable
                  show-overflow-tooltip>
                  <template slot-scope="scope">
                    {{formatterDrop(scope.row,field.propCode,domainUtil.getDropName(field))}}
                  </template>
                </el-table-column>
              </template>
              <template v-else>
                <el-table-column :label="domainUtil.getFieldLabel(field)" :key="field.id"  align="center" :width="domainUtil.getWidth(field)" :prop="field.propCode" 
                  sortable
                  show-overflow-tooltip>
                </el-table-column>
              </template>
          </template>
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-edit"
                  @click="handleUpdate(scope.row)"
                >修改</el-button>  
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-delete"
                  @click="handleDelete(scope.row)"
                >删除</el-button>              
              </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>

    <el-drawer title="标签属性配置" :visible.sync="showAddDrawer" direction="rtl">
        <el-row>
          <!-- <cg-prop v-model="this.formData"  :domain-prop="this.fieldMetaList.relDomain"/> -->
          <el-form :model="formData" ref="form" :inline="false" label-width="150px">
                <template v-if="fieldMetaList!=null">
                  <el-form-item v-for="field in fieldMetaList" :key="field.id" :label="domainUtil.getFieldLabel(field)" :prop="field.propCode">
                    <el-select  v-if="domainUtil.isSelect(field)"  v-model="formData[field.propCode]" placeholder="请选择">
                        <el-option
                        v-for="item in dropdownMap[domainUtil.getDropName(field)]"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                    <el-input type="textarea" v-else-if="domainUtil.isTextarea(field)" v-model="formData[field.propName]" />
                    <el-input v-else v-model="formData[field.propCode]" />
                  </el-form-item>
                </template>
                <el-form-item>
                    <el-button type="primary" icon="el-icon-search" size="mini" @click="submitForm">确 定</el-button>
                    <el-button icon="el-icon-refresh" size="mini" @click="cancel">取 消</el-button>
                </el-form-item>
            </el-form>
        </el-row>
    </el-drawer>
  </div>
</template>

<script>
import { getTableMeta,getFieldsMeta,saveData,deleteData } from "@/api/cg/tableFieldConfig";
import { getTableDataAll } from "@/api/database/databaseApi.js"
import CgProp from "./cgProp.vue";
export default {
  name: "SingleTableView",
  components: { CgProp },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      getTable: true,
      // 用户表格数据
      tableDataList: null,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 表单参数
      form: {},
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: undefined,
        phonenumber: undefined,
        status: undefined,
        deptId: undefined
      },
      
      tableMetaData:{},
      fieldMetaList:[],
      tableId:null,
      showAddDrawer:false,
      formData:{},
      // tableSelectList:[],
      dropdownMap:{},
    };
  },
  watch: {
    tableId(val){
      getTableMeta(val).then(response=>{
          console.log(response);
          const data = response.parameterMap.data;
          this.tableMetaData = data;
          this.getTableDataAll();
      })

      getFieldsMeta(val).then(response=>{
          console.log(response);
          const data = response.parameterMap.data;
          this.fieldMetaList = data;
          this.getAllDict();
      })
    }
  },
  created() {
    //console.log("获取this.$route.params");
    const tableId = this.$route.query.tableId;
    this.tableId = tableId;
    // getTableDataAll("cg_config_table").then(response=>{
    //    this.tableSelectList = response.parameterMap.data;
    // })
  },
  methods: {
    formatterDrop(row, columnName,dropName) {
      console.log(row);
      console.log(columnName);
      var dropList = this.dropdownMap[dropName];
      if(dropList!=null){
        var item = dropList.find(item=>{
          return item.value == row[columnName];
        })
        if(item!=null){
          return item.label+`(${item.value})`;
        }
      }
      return row[columnName];
      
    },
    getAllDict(){
      this.fieldMetaList.forEach(item=>{
        const dropName = this.domainUtil.getDropName(item);
        console.log(dropName);
        if(dropName!=""){
          if(this.dropdownMap[dropName]==null){
              this.getDrop(dropName).then(response=>{
                this.$set(this.dropdownMap,dropName,response.parameterMap.data)
            })
          }
        }        
      })
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        userId: undefined,
        deptId: undefined,
        userName: undefined,
        nickName: undefined,
        password: undefined,
        phonenumber: undefined,
        email: undefined,
        sex: undefined,
        status: "0",
        remark: undefined,
        postIds: [],
        roleIds: []
      };
      this.resetForm("form");
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.showAddDrawer = true;
      this.formData = {}
    },
    submitForm(){
      let data = {
        tableCode : this.tableMetaData.tableCode,
        fieldMap : this.formData
      }
      saveData(data).then(response=>{
        console.log(response);
        this.getTableDataAll();
      })
    },
    getTableDataAll(){
      getTableDataAll(this.tableMetaData.tableCode).then(response=>{
        this.tableDataList = response.parameterMap.data;
        this.showAddDrawer = false;
      })
    },
    handleUpdate(row){
      this.showAddDrawer = true;
      this.formData = row;
      console.log(row);
    },
    handleDelete(row){
      let data = {
        tableCode : this.tableMetaData.tableCode,
        fieldMap : row
      }
      deleteData(data).then(response=>{
        this.getTableDataAll();
      })
    },
    getSelectData(dictname){
      this.getDicts(dictname).then(response => {
      this.$set(this.dropdownMap, dictname, response.data)
      console.log(this.dropdownMap)
    });
   }
  }
};
</script>