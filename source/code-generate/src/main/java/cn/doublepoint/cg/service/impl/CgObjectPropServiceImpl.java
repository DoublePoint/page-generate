package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
@Service
public class CgObjectPropServiceImpl implements CgObjectPropService {

    @Override
    public List<CgObjectPropVO> getProps(String code){
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT c,p FROM CgDomainEntity c,CgObjectPropEntity r,CgMetaComPropEntity p WHERE " );
        sb.append(" c.domainCode = r.objectCode and r.objectType = '01' and r.propCode = p.propCode  ");
        sb.append(" AND c.domainCode=:domainCode");

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("domainCode", code);

        List<CgObjectPropVO> resultList = new ArrayList<>();
        List<Object> list = JPAUtil.executeQuery(sb.toString(), paramList);
        list.stream().forEach(item->{
            Object[] arr = (Object[]) item;
            CgObjectPropVO vo = (CgObjectPropVO) arr[0];
            CgMetaComPropVO metaProp = (CgMetaComPropVO)arr[1];
            vo.setMetaProp(metaProp);

            resultList.add(vo);
        });

        return resultList;
    }
}
