package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;

import java.util.List;

public interface ICgObjectPropDao {
    void create(CgObjectPropEntity ety);

    void create(List<CgObjectPropEntity> etyList);

    void save(List<CgObjectPropEntity> list);

    CgObjectPropEntity getObjectObjectcodePropcode(String objectCode, String propCode);

    void update(List<CgObjectPropEntity> updateList);

    void removeGenerateDomainCode(String domainCode);
}
