package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.vo.SingleTableDataVO;
import cn.doublepoint.cg.domain.vo.SingleTableQueryDataVO;
import cn.doublepoint.commonutil.StringUtil;
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
            BaseEntity baseEntity = validateRequestData(response,tableData);
            if(!StringUtil.isEmpty(response.getErrorMessage())){
                return response;
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
            BaseEntity baseEntity = validateRequestData(response,tableData);
            if(StringUtil.isEmpty(response.getErrorMessage())){
                return response;
            }
            JPAUtil.remove(baseEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
        }
        return response;
    }



    @PostMapping("/query/data")
    public AjaxResponse queryData(@RequestBody SingleTableQueryDataVO tableData){
        AjaxResponse response = new AjaxResponse();
        try {
            if(tableData== null){
                String errMsg = "Table data cannot be null.";
                Log4jUtil.error(new Exception(errMsg));
                response.setErrorMessage(errMsg);
            }
            if(!StringUtil.isEmpty(response.getErrorMessage())){
                return response;
            }
            Map.Entry<String, EntityPersister> entityClass = JPAUtil.getDaoService().getEntityClass(tableData.getTableCode());
            if(entityClass==null){
                Log4jUtil.error(new Exception("Cannot find the entity of table "+tableData.getTableCode()));
                return null;
            }
            tableData.getQueryParamList().removeEmptyValue();
            List ret = JPAUtil.load(entityClass.getValue().getMappedClass(), tableData.getQueryParamList());
            response.setAjaxParameter("data",ret);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
        }
        return response;
    }

    /**
     * 验证输入参数的有效性
     * @param response
     * @param tableData
     * @return
     */
    private BaseEntity validateRequestData(AjaxResponse response,SingleTableDataVO tableData){
        if(tableData== null){
            String errMsg = "Table data cannot be null.";
            Log4jUtil.error(new Exception(errMsg));
            response.setErrorMessage(errMsg);
        }
        BaseEntity baseEntity = tableData.mapToEntity();
        if(baseEntity == null){
            response.setErrorMessage("Save error");
        }

        return baseEntity;
    }
}
