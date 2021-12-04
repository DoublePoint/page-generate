package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldVO;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgConfigTableFieldService;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CgConfigTableFieldServiceImpl implements CgConfigTableFieldService {

    @Autowired
    SnowflakeIdWorker idWorker;

    @Autowired
    CgObjectPropService propService;

    @Autowired
    CgDomainService domainService;

    @Override
    public List<CgConfigTableFieldVO> getTableFieldTreeByTableId(String tableId){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("configTableId",tableId);
        List<CgConfigTableFieldEntity> fieldEntityList = JPAUtil.load(CgConfigTableFieldEntity.class, paramList);
        if(CollectionUtils.isEmpty(fieldEntityList)){
            Log4jUtil.debug("Get Table Field,The Count is 0.");
            return new ArrayList<>();
        }

        List<CgConfigTableFieldVO> resultList = new ArrayList<>();
        for (int i=0;i<fieldEntityList.size();i++){
            CgConfigTableFieldVO vo = new CgConfigTableFieldVO();
            CgConfigTableFieldEntity entity = fieldEntityList.get(i);

            CommonBeanUtil.copyProperties(entity,vo);
            Map<String, CgObjectPropVO> props = propService.getTableConfigProps(entity.getId());
            vo.setRelProp(props);

            CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
            vo.setRelDomain(domainTree);
            resultList.add(vo);
        }
        return resultList;
    }

    @Override
    public void add(CgConfigTableFieldEntity entity) {
        entity.setId(idWorker.nextId());
        entity.setCreateTime(CommonUtil.getDateTime());
        entity.setUpdateTime(CommonUtil.getDateTime());
        JPAUtil.create(entity);
    }

    @Override
    public void delete(CgConfigTableFieldEntity entity) {
        JPAUtil.remove(entity);
    }

    @Override
    public void delete(List<String> ids) {
        ids.stream().forEach(item->{
            JPAUtil.remove(CgConfigTableFieldEntity.class,item);
        });
    }

    @Override
    public void update(CgConfigTableFieldEntity entity) {
        JPAUtil.update(entity);
    }
}
