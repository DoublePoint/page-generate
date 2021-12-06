package cn.doublepoint.cg.domain.vo;

import java.sql.Timestamp;
import java.util.Map;

public class CgConfigTableFieldVO {
    private String id;
    private String configTableId;
    private String propCode;
    private String propName;
    private String dropName;
    private String comCode;
    private String domainCode;
    private String fieldCode;
    private Integer sort;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    private Map<String,CgObjectPropVO> relObjectProp;
    private CgDomainVO relDomain;

    public CgDomainVO getRelDomain() {
        return relDomain;
    }

    public void setRelDomain(CgDomainVO relDomain) {
        this.relDomain = relDomain;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfigTableId() {
        return configTableId;
    }

    public void setConfigTableId(String configTableId) {
        this.configTableId = configTableId;
    }

    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getDropName() {
        return dropName;
    }

    public void setDropName(String dropName) {
        this.dropName = dropName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Map<String, CgObjectPropVO> getRelObjectProp() {
        return relObjectProp;
    }

    public void setRelObjectProp(Map<String, CgObjectPropVO> relObjectProp) {
        this.relObjectProp = relObjectProp;
    }
}
