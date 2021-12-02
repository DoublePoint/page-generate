package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.vo.SingleTableDataVO;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.dto.domain.model.entity.BaseEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cg/single/table")
public class SingleTableModifyController {

    @PostMapping("data")
    public AjaxResponse addData(@RequestBody SingleTableDataVO tableData){
        AjaxResponse response = new AjaxResponse();
        try {
            if(tableData== null){
                Log4jUtil.error(new Exception("Table data cannot be null."));
                return response;
            }
            BaseEntity baseEntity = tableData.mapToEntity();
            if(baseEntity == null){
                response.setErrorMessage("Save error");
                return  response;
            }
            JPAUtil.saveOrUpdate(baseEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
        }
        return response;
    }



    @DeleteMapping("/data")
    public AjaxResponse allTableData(@RequestBody SingleTableDataVO tableData){
        AjaxResponse response = new AjaxResponse();
        try {
            if(tableData== null){
                Log4jUtil.error(new Exception("Table data cannot be null."));
                return response;
            }
            BaseEntity baseEntity = tableData.mapToEntity();
            if(baseEntity == null){
                response.setErrorMessage("Save error");
                return  response;
            }
            JPAUtil.remove(baseEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
        }
        return response;
    }
}
