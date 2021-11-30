package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.service.CgMetaComPropRelService;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CgMetaComPropRelServiceImpl implements CgMetaComPropRelService {

    @Override
    public List<CgMetaComPropVO> getProps(String comCode){
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT p FROM CgMetaComEntity c,CgMetaComPropRelEntity r,CgMetaComPropEntity p WHERE c.comCode = r.comCode and r.propCode = p.propCode  ");
        sb.append(" AND c.comCode=:comCode");

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("comCode", comCode);
        List<CgMetaComPropVO> result = JPAUtil.executeQueryModel(sb.toString(), paramList, CgMetaComPropVO.class);
        return result;
    }
}
