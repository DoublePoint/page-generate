package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.log.Log4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cg/domain")
public class DomainController {

    @Autowired
    CgObjectPropService propService;

    @PostMapping("/object/prop")
    public AjaxResponse saveObjectProp(@RequestBody List<CgObjectPropEntity> propEntityList){
        AjaxResponse response = new AjaxResponse();
        try {
            propService.save(propEntityList);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
