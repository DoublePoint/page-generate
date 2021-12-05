package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgObjectPropEntity;

import java.util.List;

public interface ICgObjectPropDao {
    void create(CgObjectPropEntity ety);

    void create(List<CgObjectPropEntity> etyList);

    void save(List<CgObjectPropEntity> list);
}
