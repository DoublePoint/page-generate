package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created on 2021/12/3.
 *
 * @author DoublePoint
 */
@Repository
public class CgMetaComDao implements ICgMetaComDao{

    @Override
    public CgMetaComEntity getByCode(String code){
        QueryParamList qy = new QueryParamList();
        qy.addParam("comCode",code);
        List<CgMetaComEntity> list = JPAUtil.load(CgMetaComEntity.class, qy);
        CgMetaComEntity t = null;
        if(!CollectionUtils.isEmpty(list)) {
            t = list.get(0);
        }
        Log4jUtil.debug("Cannot find the CgMetaCom by code of "+code);
        return t;
    }
}
