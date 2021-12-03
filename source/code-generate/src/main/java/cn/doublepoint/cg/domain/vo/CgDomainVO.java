package cn.doublepoint.cg.domain.vo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class CgDomainVO{
    private String id;
    private String domainCode;
    private String domainName;
    private String domainType;
    private String comCode;
    private String parentDomainCode;
    private String domainRelaType;
    private String define;
    private String enable;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;

    private Map<String,List<CgDomainVO>> relDomain;
    private Map<String,CgObjectPropVO> relProp;
    private CgMetaComVO relCom;

    public CgMetaComVO getRelCom() {
        return relCom;
    }

    public void setRelCom(CgMetaComVO relCom) {
        this.relCom = relCom;
    }

    public Map<String, List<CgDomainVO>> getRelDomain() {
        return relDomain;
    }

    public void setRelDomain(Map<String, List<CgDomainVO>> relDomain) {
        this.relDomain = relDomain;
    }

    public Map<String, CgObjectPropVO> getRelProp() {
        return relProp;
    }

    public void setRelProp(Map<String, CgObjectPropVO> relProp) {
        this.relProp = relProp;
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
