package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;

import java.util.List;

public interface CgMetaComPropRelService {

    List<CgMetaComPropVO> getProps(String comCode);
}
