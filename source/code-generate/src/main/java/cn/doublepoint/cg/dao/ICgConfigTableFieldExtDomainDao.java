package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldExtDomainEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldExtDomainVO;

public interface ICgConfigTableFieldExtDomainDao {
    void create(CgConfigTableFieldExtDomainEntity extDomain);

    void update(CgConfigTableFieldExtDomainEntity extDomain);
}
