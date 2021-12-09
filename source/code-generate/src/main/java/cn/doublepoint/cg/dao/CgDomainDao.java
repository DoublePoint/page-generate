package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created on 2021/12/3.
 *
 * @author DoublePoint
 */
@Repository
public class CgDomainDao implements ICgDomainDao{

    @Override
    public void create(CgDomainEntity ety){
        if(ety.getCreateTime()==null){
            ety.setCreateTime(CommonUtil.getDateTime());
        }
        if(ety.getCreateUserId()==null){
        }
        JPAUtil.create(ety);
    }


    @Override
    public void create(List<CgDomainEntity> etyList){
        if(CollectionUtils.isEmpty(etyList)){
            Log4jUtil.warn("Doamin list is empty");
            return;
        }
        etyList.stream().forEach(ety->{
            if(ety.getCreateTime()==null){
                ety.setCreateTime(CommonUtil.getDateTime());
            }
            if(ety.getCreateUserId()==null){
            }
        });

        JPAUtil.create(etyList);
    }

    @Override
    public CgDomainEntity getByCode(String code){
        QueryParamList qy = new QueryParamList();
        qy.addParam("domainCode",code);
        List<CgDomainEntity> list = JPAUtil.load(CgDomainEntity.class, qy);
        CgDomainEntity t = null;
        if(!CollectionUtils.isEmpty(list)) {
            t = list.get(0);
        }
        Log4jUtil.debug("Cannot find the CgMetaCom by code of "+code);
        return t;
    }

    @Override
    public void deleteDomainAndProp(String domainCode){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM CgDomainEntity E WHERE E.domainCode = :domainCode");
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("domainCode", domainCode);
        JPAUtil.executeUpdate(sb.toString(),paramList);

        sb = new StringBuffer();
        sb.append(("DELETE FROM CgObjectPropEntity P WHERE P.domainCode = :domainCode"));
        JPAUtil.executeUpdate(sb.toString(),paramList);
    }
}
