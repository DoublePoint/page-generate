package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldVO;
import cn.doublepoint.cg.domain.vo.SaveExtPropCmdVO;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CgConfigTableFieldService {
    List<CgConfigTableFieldVO> getTableFieldTreeByTableId(String tableId);

    List<CgConfigTableFieldVO> getTableFieldTreeByTableIdV2(String tableId);

    void add(CgConfigTableFieldEntity tableEntity);

    void changeDefaultDomain(String fieldId, String domainCode);

    /*void saveExtDomainCode(String fieldId, String domainCode);*/

    AjaxResponse saveFieldExtendProp(@RequestBody SaveExtPropCmdVO cmd);

    AjaxResponse saveFieldExtendProp2(@RequestBody SaveExtPropCmdVO cmd);

    void delete(CgConfigTableFieldEntity tableEntity);

    void delete(List<String> ids);

    void update(CgConfigTableFieldEntity tableEntity);

    CgConfigTableFieldVO getById(String tableId);
}
