package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.service.CgConfigTableFieldService;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.log.Log4jUtil;
import org.aspectj.apache.bcel.classfile.Module;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cg/domain")
public class DomainController {

    @Autowired
    CgObjectPropService propService;
    @Autowired
    CgDomainService domainService;
    @Autowired
    CgConfigTableFieldService fieldService;

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

    @GetMapping("/{domainCode}")
    public AjaxResponse getDomain(@PathVariable String domainCode){
        AjaxResponse response = new AjaxResponse();
        try {
            CgDomainVO domain = domainService.getDomainTreeByCode(domainCode);
            response.setAjaxParameter("data", domain);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
        }
        return response;
    }


    @PostMapping("/{domainCode}/to/field/" +
            "{fieldId}")
    public AjaxResponse createDomain(@PathVariable(required = true) String fieldId, @PathVariable(required = false) String domainCode){
        AjaxResponse response = new AjaxResponse();
        try {
//            CgDomainEntity result = domainService.copy(domainCode);
            fieldService.changeDomainCode(fieldId, domainCode);
//            response.setAjaxParameter("data", result);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
