package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_meta_com_prop_group", schema = "base", catalog = "")
public class CgMetaComPropGroupEntity extends BaseEntity {
    private String id;
    private String groupCode;
    private String groupName;
    private String groupType;
    private String enable;
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
    @Column(name = "GROUP_CODE")
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Basic
    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "GROUP_TYPE")
    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
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
        CgMetaComPropGroupEntity that = (CgMetaComPropGroupEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(groupCode, that.groupCode) && Objects.equals(groupName, that.groupName) && Objects.equals(groupType, that.groupType) && Objects.equals(enable, that.enable) && Objects.equals(sort, that.sort) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupCode, groupName, groupType, enable, sort, createTime, updateTime, createUserId, updateUserId);
    }
}
