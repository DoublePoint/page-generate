package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.vo.CgObjectPropVO;

import java.util.List;
import java.util.Map;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
public interface CgObjectPropService {
    Map<String,CgObjectPropVO> getProps(String code);
}
