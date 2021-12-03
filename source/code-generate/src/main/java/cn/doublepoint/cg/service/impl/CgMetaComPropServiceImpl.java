package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.vo.CgMetaComPropGroupVO;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.service.CgMetaComPropGroupService;
import cn.doublepoint.cg.service.CgMetaComPropService;
import cn.doublepoint.cg.util.CgConstant;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class CgMetaComPropServiceImpl implements CgMetaComPropService {

    @Autowired
    CgMetaComPropGroupService groupService;

    @Override
    public Map<String,List<CgMetaComPropVO>> getProps(String comCode){
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT p FROM CgMetaComEntity c,CgMetaComPropRelEntity r,CgMetaComPropEntity p WHERE c.comCode = r.comCode and r.propCode = p.propCode  ");
        sb.append(" AND c.comCode=:comCode");

        Map<String,List<CgMetaComPropVO>> returnMap = new HashMap<>();

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("comCode", comCode);
        List<CgMetaComPropVO> result = JPAUtil.executeQueryModel(sb.toString(), paramList, CgMetaComPropVO.class);
        result.stream().forEach(item->{
            CgMetaComPropGroupVO group = groupService.getPropGroup(item.getPropCode());
            if(group!=null) {
                item.setRelGroup(group);
                List<CgMetaComPropVO> cgMetaComPropVOS = returnMap.get(group.getGroupCode());
                if (CollectionUtils.isEmpty(cgMetaComPropVOS)) {
                    cgMetaComPropVOS = new ArrayList<>();
                    returnMap.put(group.getGroupCode(), cgMetaComPropVOS);
                }
                cgMetaComPropVOS.add(item);
            }
            else{
                List<CgMetaComPropVO> cgMetaComPropVOS = returnMap.get(CgConstant.COM_PROP_GROUP_KEY_DEFAULT);
                if (CollectionUtils.isEmpty(cgMetaComPropVOS)) {
                    cgMetaComPropVOS = new ArrayList<>();
                    returnMap.put(CgConstant.COM_PROP_GROUP_KEY_DEFAULT, cgMetaComPropVOS);
                }
                cgMetaComPropVOS.add(item);
            }
        });

        return returnMap;
    }


}
