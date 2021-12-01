package cn.doublepoint.cg.domain.model;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cg_config_table", schema = "base", catalog = "")
public class CgConfigTableEntity extends BaseEntity {
    private String id;
    private String tableCode;
    private String isShowRetrieveForm;
    private String isShowDelBtn;
    private String isShowUpdateBtn;
    private String isShowSaveBtn;
    private String isShowAddBtn;
    private String wherePropCode;
    private String enable;
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
    @Column(name = "TABLE_CODE")
    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    @Basic
    @Column(name = "IS_SHOW_RETRIEVE_FORM")
    public String getIsShowRetrieveForm() {
        return isShowRetrieveForm;
    }

    public void setIsShowRetrieveForm(String isShowRetrieveForm) {
        this.isShowRetrieveForm = isShowRetrieveForm;
    }

    @Basic
    @Column(name = "IS_SHOW_DEL_BTN")
    public String getIsShowDelBtn() {
        return isShowDelBtn;
    }

    public void setIsShowDelBtn(String isShowDelBtn) {
        this.isShowDelBtn = isShowDelBtn;
    }

    @Basic
    @Column(name = "IS_SHOW_UPDATE_BTN")
    public String getIsShowUpdateBtn() {
        return isShowUpdateBtn;
    }

    public void setIsShowUpdateBtn(String isShowUpdateBtn) {
        this.isShowUpdateBtn = isShowUpdateBtn;
    }

    @Basic
    @Column(name = "IS_SHOW_SAVE_BTN")
    public String getIsShowSaveBtn() {
        return isShowSaveBtn;
    }

    public void setIsShowSaveBtn(String isShowSaveBtn) {
        this.isShowSaveBtn = isShowSaveBtn;
    }

    @Basic
    @Column(name = "IS_SHOW_ADD_BTN")
    public String getIsShowAddBtn() {
        return isShowAddBtn;
    }

    public void setIsShowAddBtn(String isShowAddBtn) {
        this.isShowAddBtn = isShowAddBtn;
    }

    @Basic
    @Column(name = "WHERE_PROP_CODE")
    public String getWherePropCode() {
        return wherePropCode;
    }

    public void setWherePropCode(String wherePropCode) {
        this.wherePropCode = wherePropCode;
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
        CgConfigTableEntity that = (CgConfigTableEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(tableCode, that.tableCode) && Objects.equals(isShowRetrieveForm, that.isShowRetrieveForm) && Objects.equals(isShowDelBtn, that.isShowDelBtn) && Objects.equals(isShowUpdateBtn, that.isShowUpdateBtn) && Objects.equals(isShowSaveBtn, that.isShowSaveBtn) && Objects.equals(isShowAddBtn, that.isShowAddBtn) && Objects.equals(wherePropCode, that.wherePropCode) && Objects.equals(enable, that.enable) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(createUserId, that.createUserId) && Objects.equals(updateUserId, that.updateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableCode, isShowRetrieveForm, isShowDelBtn, isShowUpdateBtn, isShowSaveBtn, isShowAddBtn, wherePropCode, enable, createTime, updateTime, createUserId, updateUserId);
    }
}
