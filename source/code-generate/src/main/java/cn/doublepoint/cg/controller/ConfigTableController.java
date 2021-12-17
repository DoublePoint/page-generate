package cn.doublepoint.cg.controller;


import cn.doublepoint.cg.domain.model.CgConfigTableEntity;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.vo.SaveExtPropCmdVO;
import cn.doublepoint.cg.service.CgConfigTableFieldService;
import cn.doublepoint.cg.service.CgConfigTableService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config/table")
public class ConfigTableController {

    @Autowired
    CgConfigTableService configTableService;
    @Autowired
    CgConfigTableFieldService fieldService;
    @Autowired
    CgObjectPropService objectPropService;

    @GetMapping("/all")
    public AjaxResponse getAllTableConfig(){
        AjaxResponse response = new AjaxResponse();
        response.setAjaxParameter("data",configTableService.getAll());
        return response;
    }

    @GetMapping("/{tableId}")
    public AjaxResponse getTableConfig(@PathVariable String tableId){
        AjaxResponse response = new AjaxResponse();
        response.setAjaxParameter("data",configTableService.get(tableId));
        return response;
    }


    @PostMapping("/")
    public AjaxResponse addTable(@RequestBody CgConfigTableEntity tableEntity){
        AjaxResponse response = new AjaxResponse();
        configTableService.add(tableEntity);
        return response;
    }


    @DeleteMapping("/")
    public AjaxResponse deleteTable(@RequestBody CgConfigTableEntity tableEntity){
        AjaxResponse response = new AjaxResponse();
        configTableService.delete(tableEntity);
        return response;
    }


    @DeleteMapping("/batch")
    public AjaxResponse deleteTable(@RequestBody List<String> ids){
        AjaxResponse response = new AjaxResponse();
        configTableService.delete(ids);
        return response;
    }


    @PutMapping("/")
    public AjaxResponse updateTable(@RequestBody CgConfigTableEntity tableEntity){
        AjaxResponse response = new AjaxResponse();
        configTableService.update(tableEntity);
        return response;
    }


    @GetMapping("/field")
    public AjaxResponse getAllTableFieldConfig(@RequestParam String tableId){
        AjaxResponse response = new AjaxResponse();
        response.setAjaxParameter("data",fieldService.getTableFieldTreeByTableId(tableId));
        return response;
    }

    @PostMapping("/field")
    public AjaxResponse addField(@RequestBody CgConfigTableFieldEntity entity){
        AjaxResponse response = new AjaxResponse();
        fieldService.add(entity);
        return response;
    }


    @DeleteMapping("/field")
    public AjaxResponse deleteField(@RequestBody CgConfigTableFieldEntity entity){
        AjaxResponse response = new AjaxResponse();
        fieldService.delete(entity);
        return response;
    }


    @DeleteMapping("/field/batch")
    public AjaxResponse deleteField(@RequestBody List<String> ids){
        AjaxResponse response = new AjaxResponse();
        fieldService.delete(ids);
        return response;
    }

    @DeleteMapping("/field/{fieldId}/domaincode")
    public AjaxResponse deleteField(@PathVariable String fieldId){
        AjaxResponse response = new AjaxResponse();
        fieldService.changeDefaultDomain(fieldId,"");
        return response;
    }


    @PutMapping("/field")
    public AjaxResponse updateField(@RequestBody CgConfigTableFieldEntity entity){
        AjaxResponse response = new AjaxResponse();
        fieldService.update(entity);
        return response;
    }

    /**
     * 保存字段的扩展属性
     * @param cmd
     * @return
     */
    @PostMapping("/field/prop")
    public AjaxResponse saveFieldExtendProp(@RequestBody SaveExtPropCmdVO cmd){
        AjaxResponse response = fieldService.saveFieldExtendProp2(cmd);
        return response;
    }

    /**
     * 保存字段的扩展属性
     * @param cmd
     * @return
     */
//    @PostMapping("/field/prop")
//    public AjaxResponse saveFieldExtendProp(@RequestBody SaveExtPropCmdVO cmd){
//        AjaxResponse response = new AjaxResponse();
//
//        CgConfigTableFieldVO field = fieldService.getById(cmd.getFieldId());
//
//        String dbDomainCode = field.getDomainCode();
//        String reuDomainCode = cmd.getDomainCode();
//        String reuFieldId = cmd.getFieldId();
//        boolean dbDomEmpty = StringUtils.isEmpty(dbDomainCode);
//        boolean reuDomEmpty = StringUtils.isEmpty(reuDomainCode);
//
//        //如果前后Domain都是空，则修改field的prop
//        if(dbDomEmpty&&reuDomEmpty){
//            objectPropService.saveFieldProp(cmd);
//            response.setErrorMessage("The domain code annot be null.");
//            return response;
//        }
//        //如果重置成了绑定Domain,处理删除原来的
//        else if(dbDomEmpty&&!reuDomEmpty){
//            fieldService.changeDomainCode(reuFieldId,reuDomainCode);
//
//            objectPropService.deleteByFieldId(reuFieldId);
//        }
//        //如果解绑了Domain，重置domainCode
//        else if(!dbDomEmpty&&reuDomEmpty){
//            fieldService.changeDomainCode(reuFieldId,"");
//            objectPropService.saveFieldProp(cmd);
//        }
//        //如果DB Domain与结果Domain都不为空
//        else {
//            if(reuDomainCode.equals(dbDomainCode)){
//                Log4jUtil.warn("The domain code is same,will be ignore，");
//                return response;
//            }
//            else{
//                fieldService.changeDomainCode(reuFieldId,reuDomainCode);
//            }
//        }
//
//        return response;
//    }

}
