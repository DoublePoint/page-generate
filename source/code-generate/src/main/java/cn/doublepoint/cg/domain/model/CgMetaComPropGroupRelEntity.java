package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_meta_com_prop_group_rel", schema = "base", catalog = "")
public class CgMetaComPropGroupRelEntity extends BaseEntity {
    private String id;
    private String propCode;
    private String groupCode;
    private Integer sort;
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
    @Column(name = "PROP_CODE")
    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    @Basic
    @Column(name = "GROUP_CODE")
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
        CgMetaComPropGroupRelEntity that = (CgMetaComPropGroupRelEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(propCode, that.propCode) && Objects.equals(groupCode, that.groupCode) && Objects.equals(sort, that.sort) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propCode, groupCode, sort, createTime, updateTime, createUserId, updateUserId);
    }
}
