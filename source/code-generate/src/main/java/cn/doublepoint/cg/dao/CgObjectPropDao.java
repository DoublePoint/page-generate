package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import sun.rmi.runtime.Log;

import java.util.List;

@Repository
public class CgObjectPropDao implements ICgObjectPropDao{

    @Autowired
    SnowflakeIdWorker idWorker;

    @Override
    public void create(CgObjectPropEntity ety){
        if(StringUtils.isEmpty(ety.getId())){
            ety.setId(idWorker.nextId());
        }
        if(ety.getCreateTime()==null){
            ety.setCreateTime(CommonUtil.getDateTime());
        }
        if(ety.getCreateUserId()==null){
        }
        JPAUtil.create(ety);
    }


    @Override
    public void create(List<CgObjectPropEntity> etyList){
        if(CollectionUtils.isEmpty(etyList)){
            Log4jUtil.debug("Object list is empty");
            return;
        }
        etyList.stream().forEach(ety->{
            if(StringUtils.isEmpty(ety.getId())){
                ety.setId(idWorker.nextId());
            }
            if(ety.getCreateTime()==null){
                ety.setCreateTime(CommonUtil.getDateTime());
            }
            if(ety.getCreateUserId()==null){
            }
        });

        JPAUtil.create(etyList);
    }


    @Override
    public void save(List<CgObjectPropEntity> list){
        if(CollectionUtils.isEmpty(list)){
            return;
        }

        list.stream().forEach(item->{
            if(StringUtils.isEmpty(item.getId())){
                item.setId(idWorker.nextId());
            }
        });

        JPAUtil.saveOrUpdate(list);
    }

    /**
     * 根据Object Code 和 Prop code获取数据
     * @param objectCode
     * @param propCode
     */
    @Override
    public CgObjectPropEntity getObjectObjectcodePropcode(String objectCode, String propCode){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("objectCode",objectCode);
        paramList.addParam("propCode",propCode);

        List<CgObjectPropEntity> list = JPAUtil.load(CgObjectPropEntity.class, paramList);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        if(list.size()>1){
            Log4jUtil.warn("Find more than one 'Object Prop Entity' by 'Object Code' and 'Prop Code'." + objectCode + ";"+propCode);
        }

        return list.get(0);
    }

    @Override
    public void update(List<CgObjectPropEntity> updateList) {
        if(CollectionUtils.isEmpty(updateList)){
            Log4jUtil.debug("Object list is empty");
            return;
        }
        updateList.stream().forEach(ety->{
            if(ety.getUpdateTime()==null){
                ety.setUpdateTime(CommonUtil.getDateTime());
            }
            if(ety.getUpdateUserId()==null){
            }
        });

        JPAUtil.update(updateList);
    }
}
