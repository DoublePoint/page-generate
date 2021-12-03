package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_object_prop", schema = "base", catalog = "")
public class CgObjectPropEntity extends BaseEntity {
    private String id;
    private String propCode;
    private String propValue;
    private String propType;
    private String objectType;
    private String objectCode;
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
    @Column(name = "PROP_VALUE")
    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    @Basic
    @Column(name = "PROP_TYPE")
    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    @Basic
    @Column(name = "OBJECT_TYPE")
    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Basic
    @Column(name = "OBJECT_CODE")
    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
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
        CgObjectPropEntity that = (CgObjectPropEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(propCode, that.propCode) && Objects.equals(propValue, that.propValue) && Objects.equals(propType, that.propType) && Objects.equals(objectType, that.objectType) && Objects.equals(objectCode, that.objectCode) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propCode, propValue, propType, objectType, objectCode, createTime, updateTime, createUserId, updateUserId);
    }
}
