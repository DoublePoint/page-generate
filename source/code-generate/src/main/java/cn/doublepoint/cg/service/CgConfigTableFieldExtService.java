package cn.doublepoint.cg.service;

import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldExtDomainVO;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldVO;
import cn.doublepoint.cg.domain.vo.SaveExtPropCmdVO;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CgConfigTableFieldExtService {
    CgConfigTableFieldExtDomainVO getByTableFieldId(String tableFieldId);
}
