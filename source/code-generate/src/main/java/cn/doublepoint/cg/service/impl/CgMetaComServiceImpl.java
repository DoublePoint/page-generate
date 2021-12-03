package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.service.CgMetaComPropGroupService;
import cn.doublepoint.cg.service.CgMetaComPropService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class CgMetaComServiceImpl implements CgMetaComService {
    @Autowired
    CgMetaComPropService relService;
    @Autowired
    CgMetaComPropGroupService groupService;

    @Override
    public CgMetaComVO getMetaComById(String id){
        CgMetaComEntity t = JPAUtil.loadById(CgMetaComEntity.class, id);
        String comCode = t.getComCode();

        CgMetaComVO vo = new CgMetaComVO();
        CommonBeanUtil.copyProperties(t,vo);

        Map<String, List<CgMetaComPropVO>> props = relService.getProps(comCode);
        vo.setRelProp(props);
        vo.setRelPropGroup(groupService.getPropGroup(props));
        return vo;
    }

    @Override
    public CgMetaComVO getMetaComByCode(String code) {
        QueryParamList qy = new QueryParamList();
        qy.addParam("comCode",code);
        List<CgMetaComEntity> list = JPAUtil.load(CgMetaComEntity.class, qy);
        CgMetaComEntity t = null;
        if(!CollectionUtils.isEmpty(list)){
            t = list.get(0);
            String id = t.getId();
            return getMetaComById(id);
        }
        else{
            return null;
        }
    }


}
