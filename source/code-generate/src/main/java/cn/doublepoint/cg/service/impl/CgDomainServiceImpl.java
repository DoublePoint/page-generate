package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
@Service
public class CgDomainServiceImpl implements CgDomainService {

    @Autowired
    CgObjectPropService propService;

    @Override
    public CgDomainVO getDomain(String code){
        CgDomainEntity t = JPAUtil.loadById(CgDomainEntity.class, code);

        CgDomainVO vo = new CgDomainVO();
        CommonBeanUtil.copyProperties(t,vo);

        List<CgObjectPropVO> props = propService.getProps(code);
        vo.setRelProp(props);

        getSubDomain(vo);
        return vo;
    }

    public void getSubDomain(CgDomainVO domain){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("parentDomainCode", domain.getDomainCode());
        List<CgDomainEntity> subDomainList = JPAUtil.load(CgDomainEntity.class,paramList);

        List<CgDomainVO> resultList = new ArrayList<>();
        for(int i=0;i<subDomainList.size();i++){
            CgDomainVO item = resultList.get(i);
            resultList.add(getDomain(item.getDomainCode()));
            Map<String, List<CgDomainVO>> relDomain = domain.getRelDomain();
            relDomain = relDomain==null?new HashMap<>():relDomain;

            relDomain.put(item.getDomainCode(),resultList);
        }
    }
}
