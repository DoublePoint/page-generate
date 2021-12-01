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
import org.springframework.util.CollectionUtils;

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
        QueryParamList qy = new QueryParamList();
        qy.addParam("domainCode",code);
        List<CgDomainEntity> list = JPAUtil.load(CgDomainEntity.class, qy);
        CgDomainEntity t = null;
        if(!CollectionUtils.isEmpty(list)){
            t = list.get(0);
        }
        if(t==null){
            return null;
        }
        CgDomainVO vo = new CgDomainVO();
        if(t==null){
            System.out.println("//CgDomain Canot be null");
            return null;
        }
        CommonBeanUtil.copyProperties(t,vo);

        List<CgObjectPropVO> props = propService.getProps(t.getDomainCode());
        vo.setRelProp(props);

        getSubDomain(vo);
        return vo;
    }

    public void getSubDomain(CgDomainVO domain){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("parentDomainCode", domain.getDomainCode());
        List<CgDomainEntity> subDomainList = JPAUtil.load(CgDomainEntity.class,paramList);

        List<CgDomainVO> resultList = new ArrayList<>();
        if(CollectionUtils.isEmpty(subDomainList)){
            return;
        }
        for(int i=0;i<subDomainList.size();i++){
            CgDomainEntity item = subDomainList.get(i);
            CgDomainVO dom = getDomain(item.getDomainCode());
            resultList.add(dom);
            Map<String, List<CgDomainVO>> relDomain = domain.getRelDomain();
            relDomain = relDomain==null?new HashMap<>():relDomain;

            relDomain.put(item.getDomainCode(),resultList);
        }
    }
}
