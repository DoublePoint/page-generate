package cn.doublepoint.cg.service;

import cn.doublepoint.commonutil.ajaxmodel.DropBean;

import java.util.List;

public interface SysDropService {
    List<DropBean> getDropList(String dropCode);
}
