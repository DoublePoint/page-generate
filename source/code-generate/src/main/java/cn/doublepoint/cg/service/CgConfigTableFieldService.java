package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldVO;

import java.util.List;

public interface CgConfigTableFieldService {
    List<CgConfigTableFieldVO> getTableFieldTreeByTableId(String tableId);

    List<CgConfigTableFieldVO> getTableFieldTreeByTableIdV2(String tableId);

    void add(CgConfigTableFieldEntity tableEntity);

    void changeDomainCode(String fieldId, String domainCode);

    void delete(CgConfigTableFieldEntity tableEntity);

    void delete(List<String> ids);

    void update(CgConfigTableFieldEntity tableEntity);

    CgConfigTableFieldVO getById(String tableId);
}
