package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgMetaComEntity;

/**
 * Created on 2021/12/3.
 *
 * @author DoublePoint
 */
public interface ICgMetaComDao {
    CgMetaComEntity getByCode(String code);
}
