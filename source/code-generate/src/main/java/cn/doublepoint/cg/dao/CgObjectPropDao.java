package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class CgObjectPropDao implements ICgObjectPropDao{

    @Autowired
    SnowflakeIdWorker idWorker;

    @Override
    public void create(CgObjectPropEntity ety){
        if(ety.getCreateTime()!=null){
            ety.setCreateTime(CommonUtil.getDateTime());
        }
        if(ety.getCreateUserId()!=null){
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
            if(ety.getCreateTime()!=null){
                ety.setCreateTime(CommonUtil.getDateTime());
            }
            if(ety.getCreateUserId()!=null){
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
}
