package cn.doublepoint.cg.domain.vo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class CgMetaComPropVO {
    private String id;
    private String propCode;
    private String propName;
    private String propValueType;
    private String propTypeDomain;
    private String defaultValue;
    private String enable;
    private String domType;
    private Integer sort;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPropValueType() {
        return propValueType;
    }

    public void setPropValueType(String propValueType) {
        this.propValueType = propValueType;
    }

    public String getPropTypeDomain() {
        return propTypeDomain;
    }

    public void setPropTypeDomain(String propTypeDomain) {
        this.propTypeDomain = propTypeDomain;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getDomType() {
        return domType;
    }

    public void setDomType(String domType) {
        this.domType = domType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
