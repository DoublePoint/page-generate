package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgDomainEntity;

import java.util.List;

/**
 * Created on 2021/12/5.
 *
 * @author DoublePoint
 */
public interface ICgDomainDao {
    void create(CgDomainEntity ety);

    void create(List<CgDomainEntity> etyList);

    CgDomainEntity getByCode(String code);
}
