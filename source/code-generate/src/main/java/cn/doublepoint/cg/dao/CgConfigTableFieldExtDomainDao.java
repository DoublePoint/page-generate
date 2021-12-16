package cn.doublepoint.cg.dao;


import cn.doublepoint.cg.domain.model.CgConfigTableFieldExtDomainEntity;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CgConfigTableFieldExtDomainDao implements ICgConfigTableFieldExtDomainDao{

    @Autowired
    SnowflakeIdWorker idWorker;

    @Override
    public void create(CgConfigTableFieldExtDomainEntity extDomain) {
        if(StringUtils.isEmpty(extDomain.getId())){
           extDomain.setId(idWorker.nextId());
        }
        extDomain.setCreateTime(CommonUtil.getDateTime());
        JPAUtil.create(extDomain);
    }

    @Override
    public void update(CgConfigTableFieldExtDomainEntity extDomain) {
        extDomain.setUpdateTime(CommonUtil.getDateTime());
        JPAUtil.create(extDomain);
    }
}
