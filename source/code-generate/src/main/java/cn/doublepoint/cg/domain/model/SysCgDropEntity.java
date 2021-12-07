package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_cg_drop", schema = "base", catalog = "")
public class SysCgDropEntity extends BaseEntity {
    private String id;
    private String dropCode;
    private String dropName;
    private String sqlcmd;
    private String enable;
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
    @Column(name = "DROP_CODE")
    public String getDropCode() {
        return dropCode;
    }

    public void setDropCode(String dropCode) {
        this.dropCode = dropCode;
    }

    @Basic
    @Column(name = "DROP_NAME")
    public String getDropName() {
        return dropName;
    }

    public void setDropName(String dropName) {
        this.dropName = dropName;
    }

    @Basic
    @Column(name = "SQLCMD")
    public String getSqlcmd() {
        return sqlcmd;
    }

    public void setSqlcmd(String sqlcmd) {
        this.sqlcmd = sqlcmd;
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
        SysCgDropEntity that = (SysCgDropEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dropCode, that.dropCode) && Objects.equals(dropName, that.dropName) && Objects.equals(sqlcmd, that.sqlcmd) && Objects.equals(enable, that.enable) && Objects.equals(sort, that.sort) && Objects.equals(remark, that.remark) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dropCode, dropName, sqlcmd, enable, sort, remark, createTime, updateTime, createUserId, updateUserId);
    }
}
