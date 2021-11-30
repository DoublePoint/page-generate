package cn.doublepoint.cg.domain.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_meta_com_rel", schema = "base", catalog = "")
public class CgMetaComRelEntity {
    private String id;
    private String cgId;
    private String comCode;
    private String parentComCode;
    private Integer sort;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CG__ID")
    public String getCgId() {
        return cgId;
    }

    public void setCgId(String cgId) {
        this.cgId = cgId;
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
    @Column(name = "PARENT_COM_CODE")
    public String getParentComCode() {
        return parentComCode;
    }

    public void setParentComCode(String parentComCode) {
        this.parentComCode = parentComCode;
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
        CgMetaComRelEntity that = (CgMetaComRelEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(cgId, that.cgId) && Objects.equals(comCode, that.comCode) && Objects.equals(parentComCode, that.parentComCode) && Objects.equals(sort, that.sort) && Objects.equals(remark, that.remark) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cgId, comCode, parentComCode, sort, remark, createTime, updateTime, createUserId, updateUserId);
    }
}
