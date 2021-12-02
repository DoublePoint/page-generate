package cn.doublepoint.cg.domain.vo;

import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.dto.domain.model.entity.BaseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.persister.entity.EntityPersister;

import java.util.Map;

public class SingleTableDataVO {

    private String tableCode;
    private Map<String,Object> fieldMap;

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public Map<String, Object> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, Object> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public BaseEntity mapToEntity(){
        Map.Entry<String, EntityPersister> entityClass = JPAUtil.getDaoService().getEntityClass(this.tableCode);
        if(entityClass==null){
            Log4jUtil.error(new Exception("Cannot find the entity of table "+this.tableCode));
            return null;
        }
        Class clazz = entityClass.getValue().getMappedClass();

        try{
            Object obData = clazz.newInstance();
            ObjectMapper objectMapper = new ObjectMapper();
            BaseEntity data = (BaseEntity)objectMapper.convertValue(this.fieldMap,clazz);
            return data;
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
            Log4jUtil.error(new Exception("Save table error"));
        }
        return null;
    }
}
