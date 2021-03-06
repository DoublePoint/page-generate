package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;

import java.util.List;
import java.util.Map;

public interface CgMetaComPropService {

    Map<String,List<CgMetaComPropVO>> getPropsMap(String comCode);

    void getRelDomain(CgMetaComPropVO item);

}
