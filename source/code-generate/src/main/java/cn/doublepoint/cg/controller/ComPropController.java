package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.domain.vo.CgMetaComVO;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgMetaComService;
import cn.doublepoint.commonutil.StringUtil;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.log.Log4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cg/meta/com")
public class ComPropController {


    @Autowired
    CgMetaComService metaComService;

    @GetMapping("prop")
    public AjaxResponse queryMetaById(@RequestParam(required = false) String id, @RequestParam(required = false) String code){
        AjaxResponse response = new AjaxResponse();
        try{
            CgMetaComVO metaCom = null;
            if(!StringUtil.isEmpty(id)){
                metaCom = metaComService.getMetaComById(id);
            }
            else if(!StringUtil.isEmpty(code)){
                metaCom = metaComService.getMetaComByCode(code);
            }
            else{
                response.setErrorMessage("Parameter id and code cannot be all null.");
                return response;
            }
            response.setAjaxParameter("data",metaCom);
        }
        catch (Exception e){
            e.printStackTrace();
            Log4jUtil.error(e);
        }
        return response;
    }
}
