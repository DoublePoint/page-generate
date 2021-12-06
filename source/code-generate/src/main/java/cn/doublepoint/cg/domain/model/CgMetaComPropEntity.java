package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_meta_com_prop", schema = "base", catalog = "")
public class CgMetaComPropEntity extends BaseEntity {
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
    private String domainCode;

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PROP_CODE")
    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    @Basic
    @Column(name = "PROP_NAME")
    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    @Basic
    @Column(name = "PROP_VALUE_TYPE")
    public String getPropValueType() {
        return propValueType;
    }

    public void setPropValueType(String propValueType) {
        this.propValueType = propValueType;
    }

    @Basic
    @Column(name = "PROP_TYPE_DOMAIN")
    public String getPropTypeDomain() {
        return propTypeDomain;
    }

    public void setPropTypeDomain(String propTypeDomain) {
        this.propTypeDomain = propTypeDomain;
    }

    @Basic
    @Column(name = "DEFAULT_VALUE")
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Basic
    @Column(name = "ENABLE")
    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "DOM_TYPE")
    public String getDomType() {
        return domType;
    }

    public void setDomType(String domType) {
        this.domType = domType;
    }

    @Basic
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "CREATE_USER_ID")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "UPDATE_USER_ID")
    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CgMetaComPropEntity that = (CgMetaComPropEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(propCode, that.propCode) && Objects.equals(propName, that.propName) && Objects.equals(propValueType, that.propValueType) && Objects.equals(propTypeDomain, that.propTypeDomain) && Objects.equals(defaultValue, that.defaultValue) && Objects.equals(enable, that.enable) && Objects.equals(domType, that.domType) && Objects.equals(sort, that.sort) && Objects.equals(remark, that.remark) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propCode, propName, propValueType, propTypeDomain, defaultValue, enable, domType, sort, remark, createTime, updateTime, createUserId, updateUserId);
    }
}
