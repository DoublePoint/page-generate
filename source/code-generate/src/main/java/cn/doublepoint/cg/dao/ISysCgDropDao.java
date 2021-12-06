package cn.doublepoint.cg.dao;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.SysCgDropEntity;
import cn.doublepoint.cg.domain.vo.SysCgDropVO;

import java.util.List;

/**
 * Created on 2021/12/5.
 *
 * @author DoublePoint
 */
public interface ISysCgDropDao {

    SysCgDropVO getByCode(String code);
}
