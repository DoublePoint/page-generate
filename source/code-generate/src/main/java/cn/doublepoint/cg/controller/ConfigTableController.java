package cn.doublepoint.cg.controller;


import cn.doublepoint.cg.domain.model.CgConfigTableEntity;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.service.CgConfigTableFieldService;
import cn.doublepoint.cg.service.CgConfigTableService;
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


    @PutMapping("/field")
    public AjaxResponse updateField(@RequestBody CgConfigTableFieldEntity entity){
        AjaxResponse response = new AjaxResponse();
        fieldService.update(entity);
        return response;
    }
}
