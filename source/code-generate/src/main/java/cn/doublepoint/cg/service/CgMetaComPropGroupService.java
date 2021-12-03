package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldVO;
import cn.doublepoint.cg.domain.vo.CgMetaComPropGroupVO;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;

import java.util.List;
import java.util.Map;

public interface CgMetaComPropGroupService {
    CgMetaComPropGroupVO getPropGroup(String propCode);

    List<CgMetaComPropGroupVO> getPropGroup(Map<String, List<CgMetaComPropVO>> map);
}
