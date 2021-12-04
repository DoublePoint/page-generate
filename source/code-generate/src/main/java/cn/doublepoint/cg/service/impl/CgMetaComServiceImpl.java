package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.dao.ICgMetaComDao;
import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.service.CgMetaComPropGroupService;
import cn.doublepoint.cg.service.CgMetaComPropService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CgMetaComServiceImpl implements CgMetaComService {
    @Autowired
    CgMetaComPropService relService;
    @Autowired
    CgMetaComPropGroupService groupService;
    @Autowired
    ICgMetaComDao comDao;

    @Override
    public CgMetaComVO getMetaComById(String id){
        CgMetaComEntity t = JPAUtil.loadById(CgMetaComEntity.class, id);
        String comCode = t.getComCode();

        CgMetaComVO vo = new CgMetaComVO();
        CommonBeanUtil.copyProperties(t,vo);

        Map<String, List<CgMetaComPropVO>> props = relService.getPropsMap(comCode);
        vo.setRelProp(props);
        vo.setRelPropGroup(groupService.getPropGroup(props));
        return vo;
    }

    @Override
    public CgMetaComVO getMetaComByCode(String code) {
        CgMetaComEntity t = comDao.getByCode(code);
        if(t!=null){
            String id = t.getId();
            return getMetaComById(id);
        }
        else{
            return null;
        }
    }

    @Override
    public CgMetaComVO getMetaComPropCom(String code){
        CgMetaComEntity t = comDao.getByCode(code);
        if(t!=null){
            String id = t.getId();
            String comCode = t.getComCode();

            CgMetaComVO vo = new CgMetaComVO();
            CommonBeanUtil.copyProperties(t,vo);

            List<CgMetaComPropVO> props = relService.getProps(comCode);
            vo.setRelPropList(props);
            return vo;
        }
        else{
            return null;
        }
    }

}
