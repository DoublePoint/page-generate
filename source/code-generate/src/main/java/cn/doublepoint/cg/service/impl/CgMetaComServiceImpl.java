package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.service.CgMetaComPropRelService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CgMetaComServiceImpl implements CgMetaComService {
    @Autowired
    CgMetaComPropRelService relService;

    @Override
    public CgMetaComVO getMetaCom(String id){
        CgMetaComEntity t = JPAUtil.loadById(CgMetaComEntity.class, id);
        String comCode = t.getComCode();

        CgMetaComVO vo = new CgMetaComVO();
        CommonBeanUtil.copyProperties(t,vo);

        List<CgMetaComPropVO> props = relService.getProps(comCode);
        vo.setComPropList(props);

        return vo;

    }
}
