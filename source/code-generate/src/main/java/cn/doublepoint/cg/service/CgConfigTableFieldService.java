package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgConfigTableEntity;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;

import java.util.List;

public interface CgConfigTableFieldService {
    List<CgConfigTableFieldEntity> getTableField(String tableId);

    void add(CgConfigTableFieldEntity tableEntity);

    void delete(CgConfigTableFieldEntity tableEntity);

    void delete(List<String> ids);

    void update(CgConfigTableFieldEntity tableEntity);
}
