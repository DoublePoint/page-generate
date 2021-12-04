package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    CgMetaComService comService;

    @Override
    public CgDomainVO getDomainById(String id){
        CgDomainEntity t = JPAUtil.loadById(CgDomainEntity.class, id);
        CgDomainVO vo = new CgDomainVO();
        if(t==null){
            Log4jUtil.error(new Exception("CgDomain Canot be null"));
            return null;
        }
        CommonBeanUtil.copyProperties(t,vo);

        Map<String, CgObjectPropVO> props = propService.getProps(t.getDomainCode());
        vo.setRelProp(props);

        if(!StringUtils.isEmpty(t.getComCode())){
            CgMetaComVO metaCom = comService.getMetaComByCode(t.getComCode());
            vo.setRelCom(metaCom);
        }
        else{
            Log4jUtil.error(new Exception("Cannot find the rel comCode,the domainId is "+id));
        }
        getSubDomain(vo);
        return vo;
    }


    @Override
    public CgDomainVO getDomain(String code){
        QueryParamList qy = new QueryParamList();
        qy.addParam("domainCode",code);
        List<CgDomainEntity> list = JPAUtil.load(CgDomainEntity.class, qy);
        CgDomainEntity t = null;
        if(!CollectionUtils.isEmpty(list)){
            t = list.get(0);
        }
        String id = t.getId();
        return getDomainById(id);
    }

    public void getSubDomain(CgDomainVO domain){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("parentDomainCode", domain.getDomainCode());
        List<CgDomainEntity> subDomainList = JPAUtil.load(CgDomainEntity.class,paramList);

        if(CollectionUtils.isEmpty(subDomainList)){
            return;
        }

        Map<String, List<CgDomainVO>> relDomain = domain.getRelDomain();
        relDomain = relDomain==null?new HashMap<>():relDomain;

        for(int i=0;i<subDomainList.size();i++){
            CgDomainEntity item = subDomainList.get(i);
            CgDomainVO dom = getDomain(item.getDomainCode());

            List<CgDomainVO> cgDomainVOS = relDomain.get(item.getDomainType());
            if(CollectionUtils.isEmpty(cgDomainVOS)){
                cgDomainVOS = new ArrayList<>();
                relDomain.put(item.getDomainType(),cgDomainVOS);
            }
            cgDomainVOS.add(dom);
        }
        domain.setRelDomain(relDomain);
    }
}
