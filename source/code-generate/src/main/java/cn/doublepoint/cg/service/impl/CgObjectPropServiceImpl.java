package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.model.CgMetaComPropEntity;
import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
@Service
public class CgObjectPropServiceImpl implements CgObjectPropService {

    @Override
    public Map<String,CgObjectPropVO> getProps(String code){
        Map<String,CgObjectPropVO> map = new HashMap<>();
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT r,p FROM CgObjectPropEntity r,CgMetaComPropEntity p WHERE " );
        sb.append(" r.objectType = '01' and r.propCode = p.propCode  ");
        sb.append(" AND r.objectCode=:domainCode");

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("domainCode", code);

//        List<CgObjectPropVO> resultList = new ArrayList<>();
        List<Object> list = JPAUtil.executeQuery(sb.toString(), paramList);
        list.stream().forEach(item->{
            Object[] arr = (Object[]) item;
            CgObjectPropEntity propEntity = (CgObjectPropEntity)arr[0];
            CgMetaComPropEntity metaPropEntity = (CgMetaComPropEntity)arr[1];

            CgObjectPropVO vo = new CgObjectPropVO();
            CommonBeanUtil.copyProperties(propEntity, vo);
            CgMetaComPropVO metaProp = new CgMetaComPropVO();
            CommonBeanUtil.copyProperties(metaPropEntity, metaProp);
            vo.setMetaProp(metaProp);

            map.put(metaProp.getPropName(),vo);
//            resultList.add(vo);
        });
        return map;
    }
}
