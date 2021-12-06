package cn.doublepoint.cg.controller;

import cn.doublepoint.cg.service.SysDropService;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.ajaxmodel.DropBean;
import cn.doublepoint.commonutil.log.Log4jUtil;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sys/extend/")
public class SysExtendQueryController {

    @Autowired
    SysDropService dropService;

    @GetMapping("/drop")
    public AjaxResponse list(@RequestParam String dropCode){
        AjaxResponse response = new AjaxResponse();
        try {
            List<DropBean> dropList = dropService.getDropList(dropCode);
            response.setAjaxParameter("data",dropList);
        }
        catch (Exception e){
            Log4jUtil.error(e);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

}
