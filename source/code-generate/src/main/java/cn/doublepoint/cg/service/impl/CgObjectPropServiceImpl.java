package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;

import java.util.List;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
public class CgObjectPropServiceImpl implements CgObjectPropService {

    @Override
    public List<CgObjectPropVO> getProps(String code){
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT p FROM CgDomainEntity c,CgObjectPropEntity WHERE c.domainCode = r.objectCode and r.objectType = '01'  ");
        sb.append(" AND c.domainCode=:domainCode");

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("domainCode", code);
        List<CgObjectPropVO> result = JPAUtil.executeQueryModel(sb.toString(), paramList, CgObjectPropVO.class);
        return result;
    }
}
