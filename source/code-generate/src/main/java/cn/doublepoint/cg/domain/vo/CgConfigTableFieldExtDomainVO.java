package cn.doublepoint.cg.domain.vo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class CgConfigTableFieldExtDomainVO {
    private String id;
    private String configTableFieldId;
    private String domainCode;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CgConfigTableFieldExtDomainVO that = (CgConfigTableFieldExtDomainVO) o;
        return Objects.equals(id, that.id) && Objects.equals(configTableFieldId, that.configTableFieldId) && Objects.equals(domainCode, that.domainCode) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, configTableFieldId, domainCode, createTime, updateTime, createUserId, updateUserId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfigTableFieldId() {
        return configTableFieldId;
    }

    public void setConfigTableFieldId(String configTableFieldId) {
        this.configTableFieldId = configTableFieldId;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
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
