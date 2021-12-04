package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;

import java.util.List;
import java.util.Map;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
public interface CgObjectPropService {
    void save(List<CgObjectPropEntity> list);

    Map<String,CgObjectPropVO> getProps(String code);

    Map<String,CgObjectPropVO> getTableConfigProps(String code);
}
