package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.commonutil.port.adapter.controller.BaseController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSetMetaData;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cg")
public class GenerateController  extends BaseController{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CgMetaComService metaComService;

	@Autowired
	CgDomainService domainService;

	@RequestMapping("/meta/queryform")
	public AjaxResponse queryform(@RequestParam String id){
		AjaxResponse response = new AjaxResponse();

		CgMetaComVO metaCom = metaComService.getMetaCom(id);
		response.setAjaxParameter("metaCom",metaCom);
		return response;
	}


	@RequestMapping("/analize")
	public AjaxResponse analize(@RequestParam String sql){

		AjaxResponse response = new AjaxResponse();
		sql = "SELECT * FROM ("+sql+") LL_GENERATE WHERE 1=2";
		List<Object> list = JPAUtil.executeNativeQuery(sql);
		ResultSetWrappingSqlRowSetMetaData metaData = (ResultSetWrappingSqlRowSetMetaData)jdbcTemplate.queryForRowSet(sql).getMetaData();


		response.setAjaxParameter("data",list);
		response.setAjaxParameter("metaData",JSON.toJSONString(mapToMap(metaData)));
		return response;
	}

	@RequestMapping("/field/base")
	public AjaxResponse queryform(){
		AjaxResponse response = new AjaxResponse();

		CgDomainVO base = domainService.getDomain("BASE");
		response.setAjaxParameter("data",base);
		return response;
	}

	public Map mapToMap(ResultSetWrappingSqlRowSetMetaData metaData){
		String[] columns = metaData.getColumnNames();
		Map map = new HashMap();
		for (int ii=0;ii<columns.length;ii++){
			String column = columns[ii];
			int i = ii+1;
			ColumnProp columnProp = new ColumnProp();

			columnProp.setCatalogName(metaData.getCatalogName(i));
			columnProp.setColumnClassName(metaData.getColumnClassName(i));
			columnProp.setColumnLabel(metaData.getColumnLabel(i));
			columnProp.setColumnType(metaData.getColumnType(i));
			columnProp.setColumnDisplaySize(metaData.getColumnDisplaySize(i));
			columnProp.setColumnTypeName(metaData.getColumnTypeName(i));
			columnProp.setTableName(metaData.getTableName(i));
			columnProp.setSchemaName(metaData.getSchemaName(i));
			columnProp.setScale(metaData.getScale(i));

			map.put(column,columnProp);
		}

		return map;

	}

	class ColumnProp{
		private String catalogName;
		private String columnClassName;
		private String columnLabel;
		private int columnType;
		private int columnDisplaySize;
		private String columnTypeName;
		private String tableName;
		private String schemaName;
		private int scale;

		public String getColumnClassName() {
			return columnClassName;
		}

		public void setColumnClassName(String columnClassName) {
			this.columnClassName = columnClassName;
		}

		public String getColumnLabel() {
			return columnLabel;
		}

		public void setColumnLabel(String columnLabel) {
			this.columnLabel = columnLabel;
		}

		public int getColumnType() {
			return columnType;
		}

		public void setColumnType(int columnType) {
			this.columnType = columnType;
		}

		public int getColumnDisplaySize() {
			return columnDisplaySize;
		}

		public void setColumnDisplaySize(int columnDisplaySize) {
			this.columnDisplaySize = columnDisplaySize;
		}

		public String getColumnTypeName() {
			return columnTypeName;
		}

		public void setColumnTypeName(String columnTypeName) {
			this.columnTypeName = columnTypeName;
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public String getSchemaName() {
			return schemaName;
		}

		public void setSchemaName(String schemaName) {
			this.schemaName = schemaName;
		}

		public int getScale() {
			return scale;
		}

		public void setScale(int scale) {
			this.scale = scale;
		}

		public String getCatalogName() {
			return catalogName;
		}

		public void setCatalogName(String catalogName) {
			this.catalogName = catalogName;
		}

	}

}
