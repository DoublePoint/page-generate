package cn.doublepoint.cg.domain.vo;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;

public class CgConfigTableVO extends BaseEntity {
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

    private Map<String,CgObjectPropVO> relProp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getIsShowRetrieveForm() {
        return isShowRetrieveForm;
    }

    public void setIsShowRetrieveForm(String isShowRetrieveForm) {
        this.isShowRetrieveForm = isShowRetrieveForm;
    }

    public String getIsShowDelBtn() {
        return isShowDelBtn;
    }

    public void setIsShowDelBtn(String isShowDelBtn) {
        this.isShowDelBtn = isShowDelBtn;
    }

    public String getIsShowUpdateBtn() {
        return isShowUpdateBtn;
    }

    public void setIsShowUpdateBtn(String isShowUpdateBtn) {
        this.isShowUpdateBtn = isShowUpdateBtn;
    }

    public String getIsShowSaveBtn() {
        return isShowSaveBtn;
    }

    public void setIsShowSaveBtn(String isShowSaveBtn) {
        this.isShowSaveBtn = isShowSaveBtn;
    }

    public String getIsShowAddBtn() {
        return isShowAddBtn;
    }

    public void setIsShowAddBtn(String isShowAddBtn) {
        this.isShowAddBtn = isShowAddBtn;
    }

    public String getWherePropCode() {
        return wherePropCode;
    }

    public void setWherePropCode(String wherePropCode) {
        this.wherePropCode = wherePropCode;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
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

    public Map<String, CgObjectPropVO> getRelProp() {
        return relProp;
    }

    public void setRelProp(Map<String, CgObjectPropVO> relProp) {
        this.relProp = relProp;
    }
}
