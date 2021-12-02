package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgConfigTableEntity;

import java.util.List;

public interface CgConfigTableService {
    List<CgConfigTableEntity> getAll();

    void add(CgConfigTableEntity tableEntity);

    CgConfigTableEntity get(String id);

    void delete(CgConfigTableEntity tableEntity);

    void delete(List<String> ids);

    void update(CgConfigTableEntity tableEntity);
}
