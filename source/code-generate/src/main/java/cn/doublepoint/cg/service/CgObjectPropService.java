package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.vo.CgObjectPropVO;

import java.util.List;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
public interface CgObjectPropService {
    List<CgObjectPropVO> getProps(String code);
}
