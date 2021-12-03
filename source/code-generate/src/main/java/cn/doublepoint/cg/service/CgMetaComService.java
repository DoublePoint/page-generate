package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgMetaComEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComVO;

public interface CgMetaComService {
    CgMetaComVO getMetaComById(String id);
    CgMetaComVO getMetaComByCode(String code);
}
