package cn.doublepoint.cg.domain.vo;

import java.util.List;

public class SaveExtPropCmdVO {
    private String fieldId;
    private String domainCode;
    private List<SaveExtPropCmdSubVO> prop;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public List<SaveExtPropCmdSubVO> getProp() {
        return prop;
    }

    public void setProp(List<SaveExtPropCmdSubVO> prop) {
        this.prop = prop;
    }
}
