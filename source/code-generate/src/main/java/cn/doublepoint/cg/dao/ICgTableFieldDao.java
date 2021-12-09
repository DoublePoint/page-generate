package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;

/**
 * Created on 2021/12/8.
 *
 * @author DoublePoint
 */
public interface ICgTableFieldDao {

    CgConfigTableFieldEntity getById(String id);
}
