package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_domain", schema = "base", catalog = "")
public class CgDomainEntity extends BaseEntity {
    private String id;
    private String domainCode;
    private String domainName;
    private String domainType;
    private String comCode;
    private String source;
    private String parentDomainCode;
    private String domainRelaType;
    private String define;
    private String enable;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    @Basic
    @Column(name = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
    @Column(name = "DOMAIN_CODE")
    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    @Basic
    @Column(name = "DOMAIN_NAME")
    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Basic
    @Column(name = "DOMAIN_TYPE")
    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    @Basic
    @Column(name = "COM_CODE")
    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    @Basic
    @Column(name = "PARENT_DOMAIN_CODE")
    public String getParentDomainCode() {
        return parentDomainCode;
    }

    public void setParentDomainCode(String parentDomainCode) {
        this.parentDomainCode = parentDomainCode;
    }

    @Basic
    @Column(name = "DOMAIN_RELA_TYPE")
    public String getDomainRelaType() {
        return domainRelaType;
    }

    public void setDomainRelaType(String domainRelaType) {
        this.domainRelaType = domainRelaType;
    }

    @Basic
    @Column(name = "DEFINE")
    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
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
        CgDomainEntity that = (CgDomainEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(domainCode, that.domainCode) && Objects.equals(domainName, that.domainName) && Objects.equals(domainType, that.domainType) && Objects.equals(comCode, that.comCode) && Objects.equals(parentDomainCode, that.parentDomainCode) && Objects.equals(domainRelaType, that.domainRelaType) && Objects.equals(define, that.define) && Objects.equals(enable, that.enable) && Objects.equals(remark, that.remark) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domainCode, domainName, domainType, comCode, parentDomainCode, domainRelaType, define, enable, remark, createTime, updateTime, createUserId, updateUserId);
    }
}
