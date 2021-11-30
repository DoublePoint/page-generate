package cn.doublepoint.cg.domain.vo;

import cn.doublepoint.dto.domain.model.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CgMetaComVO {
    private String id;
    private String comCode;
    private String comName;
    private String comType;
    private String enable;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    private Map<String,CgMetaComVO> relCom;

    public List<CgMetaComPropVO> getComPropList() {
        return comPropList;
    }

    public void setComPropList(List<CgMetaComPropVO> comPropList) {
        this.comPropList = comPropList;
    }

    private List<CgMetaComPropVO> comPropList;

    public Map<String, CgMetaComVO> getRelCom() {
        return relCom;
    }

    public void setRelCom(Map<String, CgMetaComVO> relCom) {
        this.relCom = relCom;
    }

    public String getId() {
        return id;
    }

    public String getComCode() {
        return comCode;
    }

    public String getComName() {
        return comName;
    }

    public String getComType() {
        return comType;
    }

    public String getEnable() {
        return enable;
    }

    public String getRemark() {
        return remark;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
}
