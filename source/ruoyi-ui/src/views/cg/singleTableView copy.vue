<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-select v-model="tableId" placeholder="请选择">
        <el-option
          v-for="item in tableSelectList"
          :key="item.id"
          :label="item.tableCode"
          :value="item.id">
        </el-option>
      </el-select>
    </el-row>
    <el-row :gutter="20">
      <!--用户数据-->
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true"  label-width="100px">
          <el-form-item v-for="item in fieldMetaData" :key="item.id" :label="item.propName" :prop="item.propCode">
              <el-input v-model="queryParams[item.fieldCode]" :placeholder="item.label"/>
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
        <el-table :data="tableDataList" >
          <el-table-column type="selection" width="50" align="center" />
          <template v-for="item in fieldMetaData" >
              <template >
                <el-table-column :label="item.propName" :key="item.id"  align="center" :width="getWidth(item)" :prop="item.propCode" >
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
          <el-form :model="addForm" ref="form" :inline="false" label-width="150px">
                <template v-if="fieldMetaData!=null">
                  <el-form-item v-for="fieldVo in fieldMetaData" :key="fieldVo.id" :label="getFieldLabel(fieldVo)" :prop="fieldVo.propCode">
                    <el-select  v-if="getFieldType(fieldVo)=='03'"  v-model="addForm[fieldVo.propCode]" placeholder="请选择">
                        <el-option
                        v-for="item in dropdownMap[getDropName(fieldVo)]"
                        :key="item.dictValue"
                        :label="item.dictLabel"
                        :value="item.dictValue">
                        </el-option>
                        <el-option
                        :key="1"
                        :label="1"
                        :value="1">
                        </el-option>
                        <template>
                          <!-- {{fieldVo.relObjectProp.dropname.propValue}}{{getSelectData(fieldVo.relObjectProp.dropname.propValue)}}  -->
                        </template>
                    </el-select>
                    <el-input v-else v-model="addForm[fieldVo.propCode]" />
                    
                  </el-form-item>
                </template>
                <el-form-item>
                    <el-button type="primary" icon="el-icon-search" size="mini" @click="submitForm">确 定</el-button>
                    <el-button icon="el-icon-refresh" size="mini" @click="cancel">取 消</el-button>
                </el-form-item>
            </el-form>
            <!-- <el-form :model="addForm" ref="addForm" :inline="false" label-width="100px">
              <el-form-item v-for="item in fieldMetaData" :key="item.id" :label="item.propName" :prop="item.propCode">
                  <el-input v-model="addForm[item.propCode]" :placeholder="item.label"/>
              </el-form-item>
              <el-form-item>
                    <el-button type="primary" icon="el-icon-search" size="mini" @click="submitForm">确 定</el-button>
                    <el-button icon="el-icon-refresh" size="mini" @click="cancel">取 消</el-button>
                </el-form-item>
            </el-form> -->
        </el-row>
    </el-drawer>
  </div>
</template>

<script>
import { getTableMeta,getFieldsMeta,saveData,deleteData } from "@/api/cg/tableFieldConfig";
import { getTableDataAll } from "@/api/database/databaseApi.js"
import { getToken } from "@/utils/auth";
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
      // 总条数
      total: 0,
      // 用户表格数据
      tableDataList: null,
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      // 是否显示弹出层
      open: false,
      // 部门名称
      deptName: undefined,
      // 默认密码
      initPassword: undefined,
      // 日期范围
      dateRange: [],
      // 状态数据字典
      statusOptions: [],
      // 性别状态字典
      sexOptions: [],
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {},
      defaultProps: {
        children: "children",
        label: "label"
      },
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/user/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: undefined,
        phonenumber: undefined,
        status: undefined,
        deptId: undefined
      },
      // 列信息
      formItems:[
      ],
      
      tableMetaData:{},
      fieldMetaData:[],
      tableId:null,
      showAddDrawer:false,
      addForm:{},
      tableSelectList:[
        // {label:"sys_notice",value:"915558641136828416"},
        // {label:"cg_meta_com",value:"915924412115451904"},
      ],
      dropdownMap:{

      }
    };
  },
  watch: {
    tableId(val){
      const tableId = this.tableId;
      //console.log(tableId);
      getTableMeta(tableId).then(response=>{
          console.log(response);
          const data = response.parameterMap.data;
          this.tableMetaData = data;
          this.getTableDataAll();
      })

      getFieldsMeta(tableId).then(response=>{
          console.log(response);
          const data = response.parameterMap.data;
          this.fieldMetaData = data;
      })
    }
  },
  created() {
    getTableDataAll("cg_config_table").then(response=>{
       this.tableSelectList = response.parameterMap.data;
    })
  },
  methods: {
    getDropName(fieldVO){
      return this.pGetFieldObjPro(fieldVO,'BASE_DROPNAME');
    },
    getWidth(fieldVO){
      return this.pGetFieldObjPro(fieldVO,'BASE_WIDTH');
    },
    getFieldLabel(fieldVO){
      return this.pGetFieldObjPro(fieldVO,'BASE_LABEL');
    },
    getFieldType(fieldVO){
      return this.pGetFieldObjPro(fieldVO,'FIELD_TYPE');
    },
    pGetFieldObjPro(fieldVO,propName){
      if(fieldVO.relProp==null){
        console.log(`ID:${fieldVO.id}的fieldVO.relProp为空.`);
        return '空'
      }
      if(fieldVO.relProp[propName]==null){
        console.log(`ID:${fieldVO.id}的fieldVO.relProp.${propName}为空`);
        return '空'
      }
      return fieldVO.relProp[propName].propValue;
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
      this.addForm = {}
    },
    submitForm(){
      let data = {
        tableCode : this.tableMetaData.tableCode,
        fieldMap : this.addForm
      }
      // console.log(this.addForm);
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
      this.addForm = row;
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