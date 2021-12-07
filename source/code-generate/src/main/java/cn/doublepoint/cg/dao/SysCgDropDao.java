package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.SysCgDropEntity;
import cn.doublepoint.cg.domain.vo.SysCgDropVO;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class SysCgDropDao implements ISysCgDropDao{

    @Override
    public SysCgDropVO getByCode(String code) {
        QueryParamList qy = new QueryParamList();
        qy.addParam("dropCode",code);
        List<SysCgDropEntity> list = JPAUtil.load(SysCgDropEntity.class, qy);
        SysCgDropEntity t = null;
        if(!CollectionUtils.isEmpty(list)) {
            t = list.get(0);
        }
        SysCgDropVO vo = new SysCgDropVO();
        CommonBeanUtil.copyProperties(t,vo);
        return vo;
    }
}
