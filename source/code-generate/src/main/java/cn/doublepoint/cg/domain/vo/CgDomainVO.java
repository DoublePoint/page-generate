package cn.doublepoint.cg.domain.vo;

import cn.doublepoint.cg.domain.model.CgDomainEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CgDomainVO{
    private String id;
    private String domainCode;
    private String domainName;
    private String domainType;
    private String comCode;
    private String source;
    private String parentDomainCode;
    private String domainRelaType;
    private String define;
    private String enable;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    private Map<String,List<CgDomainVO>> relDomainMap;
    private Map<String,CgDomainVO> relDomainMapByComType;
    private Map<String,CgDomainVO> relDomainMapByDomainCode;
    private List<CgDomainVO> relDomainList;
    private Map<String,CgObjectPropVO> relObjectProp;
    private CgMetaComVO relMetaCom;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public CgMetaComVO getRelMetaCom() {
        return relMetaCom;
    }

    public void setRelMetaCom(CgMetaComVO relMetaCom) {
        this.relMetaCom = relMetaCom;
    }

    public List<CgDomainVO> getRelDomainList() {
        return relDomainList;
    }

    public void setRelDomainList(List<CgDomainVO> relDomainList) {
        this.relDomainList = relDomainList;
    }

    public Map<String, List<CgDomainVO>> getRelDomainMap() {
        return relDomainMap;
    }

    public void setRelDomainMap(Map<String, List<CgDomainVO>> relDomainMap) {
        this.relDomainMap = relDomainMap;
        if(this.relDomainMap == null){
            return;
        }
        ArrayList<List<CgDomainVO>> lists = new ArrayList<>(relDomainMap.values());
        this.relDomainList = new ArrayList<>();
        lists.stream().forEach(item->{
            this.relDomainList.addAll(item);
        });

        this.relDomainMapByComType = new HashMap<>();
        this.relDomainMapByDomainCode = new HashMap<>();
                this.relDomainList.stream().forEach(item->{
            this.relDomainMapByComType.put(item.getRelMetaCom().getComCode(),item);
            relDomainMapByDomainCode.put(item.getDomainCode(),item);
        });

    }

    public Map<String, CgDomainVO> getRelDomainMapByDomainCode() {
        return relDomainMapByDomainCode;
    }

    public void setRelDomainMapByDomainCode(Map<String, CgDomainVO> relDomainMapByDomainCode) {
        this.relDomainMapByDomainCode = relDomainMapByDomainCode;
    }

    public Map<String, CgDomainVO> getRelDomainMapByComType() {
        return relDomainMapByComType;
    }

    public void setRelDomainMapByComType(Map<String, CgDomainVO> relDomainMapByComType) {
        this.relDomainMapByComType = relDomainMapByComType;
    }

    public Map<String, CgObjectPropVO> getRelObjectProp() {
        return relObjectProp;
    }

    public void setRelObjectProp(Map<String, CgObjectPropVO> relObjectProp) {
        this.relObjectProp = relObjectProp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getParentDomainCode() {
        return parentDomainCode;
    }

    public void setParentDomainCode(String parentDomainCode) {
        this.parentDomainCode = parentDomainCode;
    }

    public String getDomainRelaType() {
        return domainRelaType;
    }

    public void setDomainRelaType(String domainRelaType) {
        this.domainRelaType = domainRelaType;
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getRemark() {
        return remark;
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
