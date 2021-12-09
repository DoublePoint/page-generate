package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.vo.CgDomainVO;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
public interface CgDomainService {
    CgDomainVO getDomainTreeByCode(String code);

    CgDomainVO getDomainTreeById(String id);

    CgDomainEntity copy(String domainCode);

    CgDomainEntity createNewDomain(String domainCode);

    void deleteDomainAndProp(String domainCode);

    CgDomainEntity createNewDomainByFieldId(String fieldId);
}
