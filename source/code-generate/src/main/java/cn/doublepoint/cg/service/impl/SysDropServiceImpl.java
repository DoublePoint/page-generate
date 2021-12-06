package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.dao.ISysCgDropDao;
import cn.doublepoint.cg.domain.vo.SysCgDropVO;
import cn.doublepoint.cg.service.SysDropService;
import cn.doublepoint.commonutil.ajaxmodel.DropBean;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDropServiceImpl implements SysDropService {

    @Autowired
    ISysCgDropDao dropDao;

    @Override
    public List<DropBean> getDropList(String dropCode){
        SysCgDropVO drop = dropDao.getByCode(dropCode);
        String sqlcmd = drop.getSqlcmd();
        if(StringUtils.isEmpty(sqlcmd)){
            Log4jUtil.error(new Exception("Cannot find the sqlcmd , code of "+dropCode));
            return new ArrayList<>();
        }
        List<Object> mapList = JPAUtil.executeNativeQuery(sqlcmd);
        List<DropBean> list=mapList.stream().map(m->{
            Object[] obj = (Object[]) m;
            DropBean dropBean=new DropBean();
            dropBean.setValue(String.valueOf(obj[0]));
            dropBean.setLabel(String.valueOf(obj[1]));
            dropBean.setFilter(String.valueOf(obj[2]));
            return dropBean;
        }).collect(Collectors.toList());

        return list;
    }
}
