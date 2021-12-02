package cn.doublepoint.cg.controller;

import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.jpa.JPAUtil;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/database/")
public class DatabaseDataController {

    @GetMapping("/all/{tableCode}")
    public AjaxResponse allTableData(@PathVariable String tableCode){
        AjaxResponse response = new AjaxResponse();

        Map.Entry<String, EntityPersister> entityClass = JPAUtil.getDaoService().getEntityClass(tableCode);
        if(entityClass==null){
            response.setErrorMessage("Cannot find the table name of "+tableCode);
            return response;
        }
        List list = JPAUtil.loadAll(entityClass.getValue().getMappedClass());
        response.setAjaxParameter("data",list);
        return response;
    }

}
