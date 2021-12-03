package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.vo.CgMetaComPropGroupVO;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.service.CgMetaComPropGroupService;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CgMetaComPropGroupServiceImpl implements CgMetaComPropGroupService {


    @Override
    public CgMetaComPropGroupVO getPropGroup(String propCode) {
        QueryParamList queryParamList = new QueryParamList();
        queryParamList.addParam("propCode",propCode);

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT g From CgMetaComPropGroupEntity g,CgMetaComPropGroupRelEntity r Where r.propCode = :propCode and r.groupCode = g.groupCode");

        List<CgMetaComPropGroupVO> groupList = JPAUtil.executeQueryModel(sb.toString(), queryParamList, CgMetaComPropGroupVO.class);
        if(!CollectionUtils.isEmpty(groupList)){
            return groupList.get(0);
        }
        return null;
    }

    @Override
    public List<CgMetaComPropGroupVO> getPropGroup(Map<String, List<CgMetaComPropVO>> map){
        if(map == null){
            return new ArrayList<>();
        }
        List<CgMetaComPropGroupVO> returnList = new ArrayList<>();
        map.forEach((key,value)->{
            List<CgMetaComPropVO> propList = value;
            if(!CollectionUtils.isEmpty(propList)) {
                propList.stream().forEach(item->{
                    CgMetaComPropGroupVO relGroup = item.getRelGroup();
                    if(relGroup==null) {
                        Log4jUtil.debug("Cannot find the rel group of prop name of "+item.getPropCode());
                    }
                    else{
                        returnList.add(relGroup);
                    }
                });
            }
        });
        return returnList.stream().distinct().sorted(Comparator.comparing((CgMetaComPropGroupVO group)->{
            return group.getSort()==null?0:group.getSort();
        })).collect(Collectors.toList());
    }

}
