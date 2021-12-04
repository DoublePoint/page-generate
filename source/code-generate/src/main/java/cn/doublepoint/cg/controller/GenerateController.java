package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.commonutil.StringUtil;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.commonutil.port.adapter.controller.BaseController;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSetMetaData;
import org.springframework.web.bind.annotation.*;

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


	@GetMapping("/meta/com/prop")
	public AjaxResponse queryMetaById(@RequestParam(required = false) String id,@RequestParam(required = false) String code){
		AjaxResponse response = new AjaxResponse();
		try{
			CgMetaComVO metaCom = null;
			if(!StringUtil.isEmpty(id)){
				metaCom = metaComService.getMetaComById(id);
			}
			else if(!StringUtil.isEmpty(code)){
				metaCom = metaComService.getMetaComByCode(code);
			}
			else{
				response.setErrorMessage("Parameter id and code cannot be all null.");
				return response;
			}
			response.setAjaxParameter("metaCom",metaCom);
		}
		catch (Exception e){
			e.printStackTrace();
			Log4jUtil.error(e);
		}
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
		try {
			CgDomainVO base = domainService.getDomainTreeByCode("BASE");
			response.setAjaxParameter("data",base);
		}
		catch (Exception e){
			e.printStackTrace();
			Log4jUtil.error(e);
		}

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
