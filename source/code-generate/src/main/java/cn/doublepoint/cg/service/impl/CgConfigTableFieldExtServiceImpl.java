package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldExtDomainVO;
import cn.doublepoint.cg.service.CgConfigTableFieldExtService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Service;

@Service
public class CgConfigTableFieldExtServiceImpl implements CgConfigTableFieldExtService {
    @Override
    public CgConfigTableFieldExtDomainVO getByTableFieldId(String tableFieldId) {
        CgConfigTableFieldEntity ent = JPAUtil.loadById(CgConfigTableFieldEntity.class, tableFieldId);
        CgConfigTableFieldExtDomainVO ret = new CgConfigTableFieldExtDomainVO();
        CommonBeanUtil.copyProperties(ent,ret);
        return ret;
    }
}
