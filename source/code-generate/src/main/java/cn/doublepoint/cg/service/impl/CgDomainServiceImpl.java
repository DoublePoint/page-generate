package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.dao.CgObjectPropDao;
import cn.doublepoint.cg.dao.ICgDomainDao;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.cg.util.CgConstant;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.logging.Logger;

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
    @Autowired
    ICgDomainDao domainDao;
    @Autowired
    SnowflakeIdWorker idWorker;
    @Autowired
    CgObjectPropDao objectDao;

    @Override
    public CgDomainVO getDomainTreeById(String id){
        CgDomainEntity t = JPAUtil.loadById(CgDomainEntity.class, id);
        CgDomainVO vo = new CgDomainVO();
        if(t==null){
            Log4jUtil.error(new Exception("CgDomain Canot be null"));
            return null;
        }
        CommonBeanUtil.copyProperties(t,vo);

        Map<String, CgObjectPropVO> props = propService.getProps(t.getDomainCode());
        vo.setRelObjectProp(props);

        if(!StringUtils.isEmpty(t.getComCode())){
            CgMetaComVO metaCom = comService.getMetaComByCode(t.getComCode());
            vo.setRelMetaCom(metaCom);
        }
        else{
            Log4jUtil.warn("Cannot find the rel comCode,the domainId is "+id);
        }
//        getSubDomain(vo);
        return vo;
    }


    @Override
    public CgDomainVO getDomainTreeByCode(String code){
        if(StringUtils.isEmpty(code)){
            return null;
        }
        CgDomainEntity t = domainDao.getByCode(code);
        if(t==null){
            return null;
        }
        String id = t.getId();
        return getDomainTreeById(id);
    }

    @Override
    public CgDomainEntity copy(String domainCode){
//        String newDomainCode = "GE_"+idWorker.nextId();
        return copy(domainCode,null);
    }

    private CgDomainEntity copy(String domainCode,String parentDomainCode){
        String newDomainCode = "GE_"+idWorker.nextId();
        CgDomainEntity newEty=null;
        CgDomainVO domainVO = this.getDomainTreeByCode(domainCode);
        if(!CollectionUtils.isEmpty(domainVO.getRelDomainList())){

            //遍历子Domain 进行递归复制
            domainVO.getRelDomainList().stream().forEach(item->{
                copy(item.getDomainCode(), newDomainCode);
            });
        }
        //Copy Domain Entity
        CgDomainEntity resDomain = domainDao.getByCode(domainCode);
        if(resDomain==null){
            Log4jUtil.debug("Cannot find the domain name of "+domainCode);
            return null;
        }
        newEty = new CgDomainEntity();
        CommonBeanUtil.copyProperties(resDomain,newEty);
        newEty.setId(idWorker.nextId());
        newEty.setDomainCode(newDomainCode);
        newEty.setParentDomainCode(parentDomainCode);

        //Copy Domain Prop
        Map<String, CgObjectPropVO> relObjectProp = domainVO.getRelObjectProp();
        ArrayList<CgObjectPropEntity> newObjectList = new ArrayList<>();
        if(relObjectProp!=null){
            for(Map.Entry<String, CgObjectPropVO> entries : relObjectProp.entrySet()){
                CgObjectPropVO prop = entries.getValue();
                CgObjectPropEntity newPropEty = new CgObjectPropEntity();
                CommonBeanUtil.copyProperties(prop, newPropEty);
                newPropEty.setId(idWorker.nextId());
                newPropEty.setObjectType(CgConstant.OBJECT_PROP_REL_TYPE_VUECOMPONENT);
                newPropEty.setObjectCode(newDomainCode);
                newObjectList.add(newPropEty);
            }
            objectDao.create(newObjectList);
        }
        domainDao.create(newEty);
        return  newEty;
    }

    public void getSubDomain(CgDomainVO domain){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("parentDomainCode", domain.getDomainCode());
        List<CgDomainEntity> subDomainList = JPAUtil.load(CgDomainEntity.class,paramList);

        if(CollectionUtils.isEmpty(subDomainList)){
            return;
        }

        Map<String, List<CgDomainVO>> relDomain = domain.getRelDomainMap();
        relDomain = relDomain==null?new HashMap<>():relDomain;

        for(int i=0;i<subDomainList.size();i++){
            CgDomainEntity item = subDomainList.get(i);
            CgDomainVO dom = getDomainTreeByCode(item.getDomainCode());

            List<CgDomainVO> cgDomainVOS = relDomain.get(item.getDomainType());
            if(CollectionUtils.isEmpty(cgDomainVOS)){
                cgDomainVOS = new ArrayList<>();
                relDomain.put(item.getDomainType(),cgDomainVOS);
            }
            cgDomainVOS.add(dom);
        }
        domain.setRelDomainMap(relDomain);
    }

    /**
     * 根据域编码创建域
     * @param domainCode
     * @return
     */
    @Override
    public CgDomainEntity createNewDomain(String domainCode) {
        CgDomainEntity entity = new CgDomainEntity();
        if(StringUtils.isEmpty(domainCode)){
            Log4jUtil.error(new Exception("Domain code cannot be null."));
            return null;
        }
        entity.setDomainCode(domainCode);
        domainDao.create(entity);
        return entity;
    }

    @Override
    public void deleteDomainAndProp(String domainCode){
        domainDao.deleteDomainAndProp(domainCode);
    }

    @Override
    public CgDomainEntity createNewDomainByFieldId(String fieldId) {
        CgConfigTableFieldEntity fieldEntity = JPAUtil.loadById(CgConfigTableFieldEntity.class, fieldId);
        if(fieldEntity==null){
            Log4jUtil.error(new Exception("Cannot find the CgConfigTableFiled id of "+fieldId));
            return null;
        }

        CgDomainEntity domainEntity = new CgDomainEntity();
        domainEntity.setId(idWorker.nextId());
        domainEntity.setDomainCode(fieldEntity.getPropCode()+"_"+domainEntity.getId());
        domainEntity.setDomainName(fieldEntity.getPropCode()+"_"+domainEntity.getId());
        domainEntity.setSource(CgConstant.DOMAIN_SOURCE_GENERATE);
        domainDao.create(domainEntity);
        return domainEntity;
    }
}
