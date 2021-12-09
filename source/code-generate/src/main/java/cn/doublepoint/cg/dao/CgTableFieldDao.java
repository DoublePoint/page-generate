package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Repository;

/**
 * Created on 2021/12/8.
 *
 * @author DoublePoint
 */
@Repository
public class CgTableFieldDao implements ICgTableFieldDao {

    @Override
    public CgConfigTableFieldEntity getById(String id){
        return JPAUtil.loadById(CgConfigTableFieldEntity.class, id);
    }
}
