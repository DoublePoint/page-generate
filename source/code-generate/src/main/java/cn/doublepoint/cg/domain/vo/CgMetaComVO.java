package cn.doublepoint.cg.domain.vo;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class CgMetaComVO {
    private String id;
    private String comCode;
    private String comName;
    private String domType;
    private String enable;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    private Map<String,CgMetaComVO> relCom;
    private Map<String,List<CgMetaComPropVO>> relPropMap;
    private List<CgMetaComPropVO> relPropList;
    private List<CgMetaComPropGroupVO> relPropGroup;

    public List<CgMetaComPropVO> getRelPropList() {
        return relPropList;
    }

    public void setRelPropList(List<CgMetaComPropVO> relPropList) {
        this.relPropList = relPropList;
    }

    public Map<String, List<CgMetaComPropVO>> getRelPropMap() {
        return relPropMap;
    }

    public void setRelPropMap(Map<String, List<CgMetaComPropVO>> relPropMap) {
        this.relPropMap = relPropMap;
        if(relPropMap!=null){
            this.relPropList = new ArrayList<>();
            Set<Map.Entry<String, List<CgMetaComPropVO>>> entries = relPropMap.entrySet();
            entries.stream().forEach(item->{
                this.relPropList.addAll(item.getValue());
            });
            this.relPropList = this.relPropList.stream().distinct().collect(Collectors.toList());
        }
    }

    public List<CgMetaComPropGroupVO> getRelPropGroup() {
        return relPropGroup;
    }

    public void setRelPropGroup(List<CgMetaComPropGroupVO> relPropGroup) {
        this.relPropGroup = relPropGroup;
    }



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CgMetaComVO that = (CgMetaComVO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(comCode, that.comCode) &&
                Objects.equals(comName, that.comName) &&
                Objects.equals(domType, that.domType) &&
                Objects.equals(enable, that.enable) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(updateUserId, that.updateUserId) &&
                Objects.equals(relCom, that.relCom) &&
                Objects.equals(relPropMap, that.relPropMap) &&
                Objects.equals(relPropList, that.relPropList) &&
                Objects.equals(relPropGroup, that.relPropGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comCode, comName, domType, enable, remark, createTime, updateTime, createUserId, updateUserId, relCom, relPropMap, relPropList, relPropGroup);
    }

    public String getDomType() {
        return domType;
    }

    public void setDomType(String domType) {
        this.domType = domType;
    }
}
