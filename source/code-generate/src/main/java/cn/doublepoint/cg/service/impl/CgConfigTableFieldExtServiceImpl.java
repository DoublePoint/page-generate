package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldExtDomainEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldExtDomainVO;
import cn.doublepoint.cg.service.CgConfigTableFieldExtService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class CgConfigTableFieldExtServiceImpl implements CgConfigTableFieldExtService {
    @Override
    public CgConfigTableFieldExtDomainVO getByTableFieldId(String tableFieldId) {

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("configTableFieldId",tableFieldId);

        List<CgConfigTableFieldExtDomainEntity> list = JPAUtil.load(CgConfigTableFieldExtDomainEntity.class, paramList);
        if(CollectionUtils.isEmpty(list)){
            return  null;
        }
        CgConfigTableFieldExtDomainEntity ent = list.get(0);
        if(ent==null){
            return null;
        }
        CgConfigTableFieldExtDomainVO ret = new CgConfigTableFieldExtDomainVO();
        CommonBeanUtil.copyProperties(ent,ret);
        return ret;
    }
}
