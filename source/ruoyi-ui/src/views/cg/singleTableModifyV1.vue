<template>
  <div class="app-container">
    <el-tabs v-model="activeName" type="card">
      <el-tab-pane label="表配置" name="first">
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
              v-hasPermi="['system:role:add']"
              >新增</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="el-icon-edit"
              size="mini"
              :disabled="single"
              @click="handleUpdate"
              v-hasPermi="['system:role:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="el-icon-delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
              v-hasPermi="['system:role:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="el-icon-download"
              size="mini"
              :loading="false"
              @click="handleExport"
              v-hasPermi="['system:role:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar
            :showSearch.sync="showSearch"
            @queryTable="getTable"
          ></right-toolbar>
        </el-row>
        <el-row :gutter="20">
          <!--用户数据-->
          <el-col :span="20" :xs="24">
            <el-table
              v-loading="loading"
              :data="tableList"
              @selection-change="handleSelectionChange"
            >
              <el-table-column type="selection" width="50" align="center" />
              <el-table-column
                label="表"
                align="center"
                prop="tableCode"
                width="160"
              >
              </el-table-column>
              <el-table-column
                label="是否显示查询Form"
                align="center"
                prop="isShowRetrieveForm"
                width="160"
              >
                <template slot-scope="scope">
                  <el-switch
                    v-model="scope.row.isShowRetrieveForm"
                    active-value="1"
                    inactive-value="0"
                  ></el-switch>
                </template>
              </el-table-column>
              <el-table-column
                label="操作"
                align="center"
                class-name="small-padding fixed-width"
              >
                <template slot-scope="scope">
                  <el-button
                    size="mini"
                    type="text"
                    icon="el-icon-edit"
                    @click="handleUpdate(scope.row)"
                    v-hasPermi="['monitor:job:edit']"
                    >修改</el-button
                  >
                  <el-button
                    size="mini"
                    type="text"
                    icon="el-icon-delete"
                    @click="handleDelete(scope.row)"
                    v-hasPermi="['monitor:job:remove']"
                    >删除</el-button
                  >
                  <el-button
                    size="mini"
                    type="text"
                    icon="el-icon-detail"
                    @click="handleDetail(scope.row)"
                    v-hasPermi="['monitor:job:remove']"
                    >表详情</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane
        label="表字段管理"
        name="second"
        :disabled="tabFiledDisabled"
      >
        <el-col :span="16" :gutter="20">
          <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
              <el-button
                type="primary"
                plain
                icon="el-icon-plus"
                size="mini"
                @click="handleAddField"
                v-hasPermi="['system:role:add']"
                >新增</el-button
              >
            </el-col>
            <el-col :span="1.5">
              <el-button
                type="success"
                plain
                icon="el-icon-edit"
                size="mini"
                :disabled="single"
                @click="handleUpdateField"
                v-hasPermi="['system:role:edit']"
                >修改</el-button
              >
            </el-col>
            <el-col :span="1.5">
              <el-button
                type="danger"
                plain
                icon="el-icon-delete"
                size="mini"
                :disabled="multiple"
                @click="handleDeleteField"
                v-hasPermi="['system:role:remove']"
                >删除</el-button
              >
            </el-col>
            <el-col :span="1.5">
              <el-button
                type="warning"
                plain
                icon="el-icon-download"
                size="mini"
                :loading="false"
                @click="handleExportField"
                v-hasPermi="['system:role:export']"
                >导出</el-button
              >
            </el-col>
            <right-toolbar
              :showSearch.sync="showSearch"
              @queryTable="getTable"
              style="margin-right: 20px"
            ></right-toolbar>
          </el-row>
          <el-row :gutter="20" class="mb8">
            <el-col>
              <el-table
                v-loading="loading"
                :data="fieldList"
                @selection-change="handleSelectionChange"
              >
                <el-table-column type="selection" width="50" align="center" />
                <el-table-column
                  label="字段编码"
                  align="center"
                  prop="propCode"
                  width="160"
                >
                </el-table-column>
                <el-table-column
                  label="字段名称"
                  align="center"
                  prop="propName"
                  width="160"
                >
                </el-table-column>
                <el-table-column
                  label="下拉名称"
                  align="center"
                  prop="dropname"
                  width="160"
                >
                </el-table-column>
                <el-table-column
                  label="排序"
                  align="center"
                  prop="sort"
                  width="160"
                >
                </el-table-column>
                <el-table-column
                  label="操作"
                  align="center"
                  class-name="small-padding fixed-width"
                >
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-detail"
                      @click="handleFieldDetail(scope.row)"
                      >字段详情</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="8">
          <el-select  v-model="selectedField.domainCode" placeholder="请选择">
              <el-option
              v-for="item in domainList"
              :key="item.id"
              :label="item.domainName"
              :value="item.id">
              </el-option>
          </el-select>
          <cg-prop v-model="fieldProp"  :domain-prop="fieldDomain"/>
          <el-button type="primary" size="mini" @click="handleSave"
            >保 存</el-button
          >
        </el-col>
      </el-tab-pane>
    </el-tabs>

    <el-drawer title="标签属性配置" :visible.sync="drawer" direction="rtl">
      <el-row>
        <el-form
          :model="tableForm"
          ref="tableForm"
          :inline="false"
          label-width="150px"
        >
          <el-form-item label="表" prop="tableCode">
            <el-input v-model="tableForm.tableCode" placeholder="表明" />
          </el-form-item>
          <el-form-item label="是否显示删除按钮" prop="isShowDelBtn">
            <el-radio-group v-model="tableForm.isShowDelBtn">
              <el-radio label="1">是</el-radio>
              <el-radio label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否显示新增按钮" prop="isShowAddBtn">
            <el-radio-group v-model="tableForm.isShowAddBtn">
              <el-radio label="1">是</el-radio>
              <el-radio label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否显示查询Form" prop="isShowRetrieveForm">
            <el-radio-group v-model="tableForm.isShowRetrieveForm">
              <el-radio label="1">是</el-radio>
              <el-radio label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="submitForm"
              >确 定</el-button
            >
            <el-button icon="el-icon-refresh" size="mini" @click="cancel"
              >取 消</el-button
            >
          </el-form-item>
        </el-form>
      </el-row>
    </el-drawer>

    <el-drawer title="标签属性配置" :visible.sync="fieldDrawer" direction="rtl">
      <el-row>
        <el-form
          :model="tableFieldForm"
          ref="tableFieldForm"
          :inline="false"
          label-width="150px"
        >
          <el-form-item label="关联表格" prop="configTableId">
            <el-input v-model="tableFieldForm.configTableId" disabled />
          </el-form-item>
          <el-form-item label="字段编码" prop="fieldCode">
            <el-input v-model="tableFieldForm.fieldCode" />
          </el-form-item>
          <el-form-item label="属性编码" prop="propCode">
            <el-input v-model="tableFieldForm.propCode" />
          </el-form-item>
          <el-form-item label="字段名称" prop="propName">
            <el-input v-model="tableFieldForm.propName" />
          </el-form-item>
          <!-- <el-form-item label="下拉名称" prop="dropName">
                    <el-input v-model="tableFieldForm.dropName" />
                </el-form-item>
                <el-form-item label="排序" prop="sort">
                    <el-input v-model="tableFieldForm.sort" />
                </el-form-item> -->
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="submitFieldForm"
              >确 定</el-button
            >
            <el-button icon="el-icon-refresh" size="mini" @click="cancelField"
              >取 消</el-button
            >
          </el-form-item>
        </el-form>
      </el-row>
    </el-drawer>
  </div>
</template>

<script>
import {
  listUser,
  getUser,
  delUser,
  addUser,
  updateUser,
  exportUser,
  resetUserPwd,
  changeUserStatus,
  importTemplate,
} from "@/api/system/user";
import {
  getTable,
  createTable,
  deleteTable,
  updateTable,
  getTableField,
  createTableField,
  deleteTableField,
  updateTableField,
} from "@/api/cg/v1";
import { getToken } from "@/utils/auth";
import { treeselect } from "@/api/system/dept";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import { saveDomainObject } from "@/api/cg/domain.js";
import { getTableDataAll } from "@/api/database/databaseApi.js"
import CgProp from "./cgProp.vue";

export default {
  name: "SingleTableModify",
  components: { CgProp },
  data() {
    return {
      // 非单个禁用
      single: true,
      ids: null,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 遮罩层
      loading: false,
      tableList: null,
      fieldList: null,
      drawer: false,
      fieldDrawer: false,
      activeName: "first",

      tableForm: {
        tableCode: "",
        isShowDelBtn: "1",
        isShowAddBtn: "1",
        isShowRetrieveForm: "1",
      },
      tableFieldForm: {
        tableCode: "",
        propCode: "",
        propName: "",
        dropName: "",
        sort: 0,
      },
      currentTableId: null,
      tabFiledDisabled: true,
      fieldProp: {
        propMap: {},
      },
      fieldDomain:{
        propMap: {},
      },
      selectedField:{},
      domainList:[]

      // comCode: "",
    };
  },
  watch: {
    // 根据名称筛选部门树
    deptName(val) {
      this.$refs.tree.filter(val);
    },
  },
  created() {
    this.getTable();
     getTableDataAll("cg_domain").then(response=>{
       this.domainList = response.parameterMap.data;
    })
  },
  methods: {
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    handleAdd() {
      this.drawer = true;
      this.tableForm = {
        tableCode: "",
        isShowDelBtn: "1",
        isShowAddBtn: "1",
        isShowRetrieveForm: "1",
      };
    },
    handleAddField() {
      this.fieldDrawer = true;
      this.activeName = "second";
      this.tableFieldForm = {
        configTableId: this.currentTableId,
        propCode: "",
        propName: "",
        dropName: "",
        sort: 0,
      };
    },
    submitForm() {
      createTable(this.tableForm).then((res) => {
        this.getTable();
        this.drawer = false;
      });
    },
    submitFieldForm() {
      createTableField(this.tableFieldForm).then((res) => {
        this.getTableField();
        this.fieldDrawer = false;
      });
    },
    cancel() {
      this.drawer = false;
    },

    cancelField() {
      this.fieldDrawer = false;
    },
    handleUpdate(row) {
      this.drawer = true;
      this.tableForm = row;
    },
    handleExport() {},
    handleDelete(row) {
      const noticeIds = row.id || this.ids;
      this.$confirm(
        '是否确认删除公告编号为"' + noticeIds + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return deleteTable(noticeIds);
        })
        .then(() => {
          this.getTable();
          this.msgSuccess("删除成功");
        })
        .catch(() => {});
    },

    handleUpdateField() {
      this.fieldDrawer = true;
      this.tableFieldForm = row;
    },
    handleExportField() {},
    handleDeleteField(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return deleteTableField(ids);
        })
        .then(() => {
          this.getTableField();
          this.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    handleDetail(row) {
      const id = row.id;
      this.currentTableId = id;
      this.activeName = "second";
      this.getTableField();
    },
    
    handleFieldDetail(row) {
      // this.comCode = row.comCode;
      console.log(row);
      this.selectedField = row;
      let domain = row.relDomain;
      this.fieldDomain = domain;
      // this.fieldProp = {
      //   objectType: "cg_domain",
      //   objectCode: row.domainCode,
      //   propMap: {},
      // };
    },
    getTable() {
      getTable().then((response) => {
        this.tableList = response.parameterMap.data;
      });
    },
    getTableField() {
      getTableField({
        tableId: this.currentTableId,
      }).then((response) => {
        console.log("getTableField");
        this.fieldList = response.parameterMap.data;
        console.log(this.fieldList);
      });
    },
    handleSave() {
      var data = this.mapToObjectProp();
      saveDomainObject(data).then((response) => {
        this.getTableField();
        this.msgSuccess("保存成功.");
      });
    },
    mapToObjectProp() {
      let arr = [];
      const { objectType, objectCode } = this.fieldProp;

      Object.keys(this.fieldProp.propMap).forEach((key, value) => {
        arr.push({
          objectType,
          objectCode,
          propCode: key,
          propValue: value,
        });
      });
      return arr;
    },
  },
  watch: {
    activeName(newVal, oldVal) {
      if (newVal == "first") {
        this.tabFiledDisabled = true;
      } else {
        this.tabFiledDisabled = false;
      }
    },
  },
};
</script>