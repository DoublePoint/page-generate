package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgConfigTableEntity;
import cn.doublepoint.cg.service.CgConfigTableService;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CgConfigTableServiceImpl implements CgConfigTableService {

    @Autowired
    SnowflakeIdWorker idWorker;

    @Override
    public List<CgConfigTableEntity> getAll(){
        return JPAUtil.loadAll(CgConfigTableEntity.class);
    }


    @Override
    public void add(CgConfigTableEntity tableEntity) {
        tableEntity.setId(idWorker.nextId());
        tableEntity.setCreateTime(CommonUtil.getDateTime());
        tableEntity.setUpdateTime(CommonUtil.getDateTime());
        JPAUtil.create(tableEntity);
    }

    @Override
    public CgConfigTableEntity get(String id) {
        return JPAUtil.loadById(CgConfigTableEntity.class,id);
    }

    @Override
    public void delete(CgConfigTableEntity tableEntity) {
        JPAUtil.remove(tableEntity);
    }

    @Override
    public void delete(List<String> ids) {
        ids.stream().forEach(item->{
            JPAUtil.remove(CgConfigTableEntity.class,item);
        });
    }

    @Override
    public void update(CgConfigTableEntity tableEntity) {
        tableEntity.setUpdateTime(CommonUtil.getDateTime());
        JPAUtil.update(tableEntity);
    }
}
