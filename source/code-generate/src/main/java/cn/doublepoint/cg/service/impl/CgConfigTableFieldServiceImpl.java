package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.dao.ICgConfigTableFieldExtDomainDao;
import cn.doublepoint.cg.dao.ICgDomainDao;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldExtDomainEntity;
import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.vo.*;
import cn.doublepoint.cg.service.CgConfigTableFieldExtService;
import cn.doublepoint.cg.service.CgConfigTableFieldService;
import cn.doublepoint.cg.service.CgDomainService;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.cg.util.CgConstant;
import cn.doublepoint.commonutil.CommonUtil;
import cn.doublepoint.commonutil.ajaxmodel.AjaxResponse;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.SnowflakeIdWorker;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CgConfigTableFieldServiceImpl implements CgConfigTableFieldService {

    @Autowired
    SnowflakeIdWorker idWorker;

    @Autowired
    CgObjectPropService propService;

    @Autowired
    CgDomainService domainService;

    @Autowired
    ICgDomainDao domainDao;

    @Autowired
    CgConfigTableFieldExtService extService;

    @Autowired
    ICgConfigTableFieldExtDomainDao extDomainDao;


    @Override
    public List<CgConfigTableFieldVO> getTableFieldTreeByTableId(String tableId){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("configTableId",tableId);
        List<CgConfigTableFieldEntity> fieldEntityList = JPAUtil.load(CgConfigTableFieldEntity.class, paramList);
        if(CollectionUtils.isEmpty(fieldEntityList)){
            Log4jUtil.debug("Get Table Field,The Count is 0.");
            return new ArrayList<>();
        }

        List<CgConfigTableFieldVO> fieldList = new ArrayList<>();
        for (int i=0;i<fieldEntityList.size();i++){
            CgConfigTableFieldVO vo = new CgConfigTableFieldVO();
            CgConfigTableFieldEntity entity = fieldEntityList.get(i);
            CommonBeanUtil.copyProperties(entity,vo);

            //获取默认域名
            if(!StringUtils.isEmpty(entity.getDomainCode())){
                CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
                vo.setRelDefaultDomain(domainTree);
            }

            //获取扩展域名
            CgConfigTableFieldExtDomainVO tableField = extService.getByTableFieldId(entity.getId());
            if(tableField!=null) {
                CgDomainVO domainTree = domainService.getDomainTreeByCode(tableField.getDomainCode());
                vo.setRelExtDomain(domainTree);
            }
            fieldList.add(vo);
        }
        return fieldList;
    }

    @Override
    public List<CgConfigTableFieldVO> getTableFieldTreeByTableIdV2(String tableId){
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("configTableId",tableId);
        List<CgConfigTableFieldEntity> fieldEntityList = JPAUtil.load(CgConfigTableFieldEntity.class, paramList);
        if(CollectionUtils.isEmpty(fieldEntityList)){
            Log4jUtil.debug("Get Table Field,The Count is 0.");
            return new ArrayList<>();
        }

        List<CgConfigTableFieldVO> fieldList = new ArrayList<>();
        for (int i=0;i<fieldEntityList.size();i++){
            CgConfigTableFieldVO vo = new CgConfigTableFieldVO();
            CgConfigTableFieldEntity entity = fieldEntityList.get(i);
            CommonBeanUtil.copyProperties(entity,vo);
            //获取默认域名
            if(!StringUtils.isEmpty(entity.getDomainCode())){
                CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
                vo.setRelDefaultDomain(domainTree);
            }

            //获取扩展域名
            CgConfigTableFieldExtDomainVO tableField = extService.getByTableFieldId(entity.getId());
            if(tableField!=null) {
                CgDomainVO domainTree = domainService.getDomainTreeByCode(tableField.getDomainCode());
                vo.setRelExtDomain(domainTree);
            }

            fieldList.add(vo);
        }
        return fieldList;
    }

    @Override
    public void add(CgConfigTableFieldEntity entity) {
        entity.setId(idWorker.nextId());
        entity.setCreateTime(CommonUtil.getDateTime());
        entity.setUpdateTime(CommonUtil.getDateTime());
        JPAUtil.create(entity);
    }

    @Override
    public void changeDefaultDomain(String fieldId, String domainCode){
        if(StringUtils.isEmpty(fieldId)){
            Log4jUtil.warn("Field id cannot be null");
            return;
        }

        CgConfigTableFieldEntity fieldEty = JPAUtil.loadById(CgConfigTableFieldEntity.class, fieldId);

        fieldEty.setDomainCode(domainCode);
        JPAUtil.update(fieldEty);
    }


    private void saveExtDomainCode(String fieldId, String domainCode){

    }



    @Override
    public AjaxResponse saveFieldExtendProp(@RequestBody SaveExtPropCmdVO cmd){
        AjaxResponse response = new AjaxResponse();

        CgConfigTableFieldEntity dbField = JPAUtil.loadById(CgConfigTableFieldEntity.class, cmd.getFieldId());
        String dbDefaultDomainCode = dbField.getDomainCode();
        String reuDomainCode = cmd.getDomainCode();
        String reuFieldId = cmd.getFieldId();
        boolean dbDomEmpty = org.apache.commons.lang.StringUtils.isEmpty(dbDefaultDomainCode);
        boolean reuDomEmpty = org.apache.commons.lang.StringUtils.isEmpty(reuDomainCode);

        CgConfigTableFieldExtDomainVO extDomain = extService.getByTableFieldId(cmd.getFieldId());

        //如果DB是空，界面也是空，则创建新的Domain并绑定到扩展属性上，默认domain置空
        if(dbDomEmpty&&reuDomEmpty){
            CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
            cmd.setDomainCode(newDomain.getDomainCode());
            Log4jUtil.debug("Cmd has been changed,please use carefully.");
            propService.saveDomainProp(cmd);
            //保存扩展域名
            saveExtDomainCode(reuFieldId,newDomain.getDomainCode());
            //清空默认域
            //clearDefaultDomainCode(cmd);
            return response;
        }
        //如果重置成了绑定Domain,处理删除原来的
        if(dbDomEmpty&&!reuDomEmpty){
            changeDefaultDomain(reuFieldId,reuDomainCode);
            //
            saveExtDomainProp(cmd);
        }
        //如果数据库Domain不空，目的域是空的则，创建新域、绑定新域、创建属性如果DB域是自动生成的则删除
        else if(!dbDomEmpty&&reuDomEmpty){
            CgDomainEntity dbDomain = domainDao.getByCode(dbDefaultDomainCode);
            //如果数据库中是默认域
            boolean isDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
            if(isDefault){
                CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
                cmd.setDomainCode(newDomain.getDomainCode());
                Log4jUtil.debug("Cmd has been changed,please use carefully.");
                propService.saveDomainProp(cmd);
                changeDefaultDomain(reuFieldId,newDomain.getDomainCode());
            }
            else{
                //更新域属性
                propService.deleteByDomainCode(dbDefaultDomainCode);
                cmd.setDomainCode(dbDefaultDomainCode);
                propService.saveDomainProp(cmd);
            }
        }
        //如果DB Domain与结果Domain都不为空
        else {
            CgDomainEntity dbDomain = domainDao.getByCode(dbDefaultDomainCode);
            CgDomainEntity reuDomain = domainDao.getByCode(reuDomainCode);
            boolean isDbDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
            boolean isResDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(reuDomain.getSource());
            //如果都是默认域
            if(isDbDefault&&isResDefault) {
                //如果前后域相等
                if(reuDomainCode.equals(dbDefaultDomainCode)){
                    Log4jUtil.warn("The domain code is same,will be ignore，");
                    return response;
                }
                else{
                    changeDefaultDomain(reuFieldId,reuDomainCode);
                }
            }
            //如果结果不是默认域
            else if (isDbDefault&&!isResDefault){
                //更新域属性
                propService.deleteByDomainCode(reuDomainCode);
                cmd.setDomainCode(reuDomainCode);
                propService.saveDomainProp(cmd);
                changeDefaultDomain(reuFieldId,reuDomainCode);
            }
            else if(!isDbDefault&&isResDefault){
                deleteDomainAndProp(dbDefaultDomainCode);
                changeDefaultDomain(reuFieldId,reuDomainCode);
            }
            //如果都不是默认域
            else {
                //如果前后域一致，代表每发生变化，只是修改了属性值，则删除原来属性，添加新属性
                if(reuDomainCode.equals(dbDefaultDomainCode)){
                    propService.deleteByDomainCode(reuDomainCode);
                    cmd.setDomainCode(reuDomainCode);
                    propService.saveDomainProp(cmd);
                }
                //否则删除原来的属性和域，添加新的属性，添加新的域，改变关联关系
                else{
                    deleteDomainAndProp(dbDefaultDomainCode);
                    CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
                    cmd.setDomainCode(newDomain.getDomainCode());
                    propService.saveDomainProp(cmd);
                    changeDefaultDomain(reuFieldId,newDomain.getDomainCode());
                }
            }
//            if(reuDomainCode.equals(dbDomainCode)){
//                Log4jUtil.warn("The domain code is same,will be ignore，");
//                return response;
//            }
//            else{
//                changeDomainCode(reuFieldId,reuDomainCode);
//                propService.saveDomainProp(cmd);
//            }
        }

        return response;
    }

    @Override
    public AjaxResponse saveFieldExtendProp2(@RequestBody SaveExtPropCmdVO cmd){
        AjaxResponse response = new AjaxResponse();

        CgConfigTableFieldEntity dbField = JPAUtil.loadById(CgConfigTableFieldEntity.class, cmd.getFieldId());
        String dbDefaultDomainCode = dbField.getDomainCode();
        String reuDomainCode = cmd.getDomainCode();
        String reuFieldId = cmd.getFieldId();
        boolean dbDomEmpty = org.apache.commons.lang.StringUtils.isEmpty(dbDefaultDomainCode);
        boolean reuDomEmpty = org.apache.commons.lang.StringUtils.isEmpty(reuDomainCode);

        CgConfigTableFieldExtDomainVO extDomain = extService.getByTableFieldId(cmd.getFieldId());

        //如果目标是空的
        if(reuDomEmpty){
            //清空默认的
            clearDefaultDomainCode(reuFieldId);
            //保存扩展域名属性
            saveExtDomainProp(cmd);

            if(!dbDomEmpty){
                CgDomainEntity dbDomain = domainDao.getByCode(dbDefaultDomainCode);
                //如果数据库中不是默认域,删除自动创建的域
                boolean isDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
                if(!isDefault) {
                    deleteDomainAndProp(cmd.getFieldId());
                }
            }
        }
        else{
            changeDefaultDomain(reuFieldId,reuDomainCode);
            saveExtDomainProp(cmd);
        }



        return response;
    }

    /**
     * 清空当前默认域
     * @param fieldId
     */
    private void clearDefaultDomainCode(String fieldId) {
        if(StringUtils.isEmpty(fieldId)){
            Log4jUtil.warn("Field id cannot be null");
            return;
        }

        CgConfigTableFieldEntity fieldEty = JPAUtil.loadById(CgConfigTableFieldEntity.class, fieldId);

        fieldEty.setDomainCode("");
        JPAUtil.update(fieldEty);
    }

    /**
     * 保存国战域属性，没有的创建，有的更新，并绑定与Field之间的关系
     * @param cmd
     */
    private void saveExtDomainProp(SaveExtPropCmdVO cmd){
        CgConfigTableFieldExtDomainVO tableField = extService.getByTableFieldId(cmd.getFieldId());
        if(tableField==null){
            CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
            cmd.setDomainCode(newDomain.getDomainCode());
            Log4jUtil.debug("Cmd has been changed,please use carefully.");
            propService.saveDomainProp(cmd);

            CgConfigTableFieldExtDomainEntity extDomain = new CgConfigTableFieldExtDomainEntity();
            extDomain.setConfigTableFieldId(cmd.getFieldId());
            extDomain.setDomainCode(newDomain.getDomainCode());
            extDomainDao.create(extDomain);
        }
        else{
            cmd.setDomainCode(tableField.getDomainCode());
            propService.saveDomainProp(cmd);
        }
    }

    /**
     * 如果是自动生成的域则删除域以及与属性
     * @param fieldId
     */
    private void deleteDomainAndProp(String fieldId){
        CgConfigTableFieldEntity fieldEntity = JPAUtil.loadById(CgConfigTableFieldEntity.class, fieldId);
        if(fieldEntity==null){
            Log4jUtil.error(new Exception("Cannot find the CgConfigTableFiled id of "+fieldId));
            return;
        }
        if(fieldEntity.getDomainCode()==null){
            return;
        }
        CgDomainEntity byCode = domainDao.getByCode(fieldEntity.getDomainCode());
        if(CgConstant.DOMAIN_SOURCE_GENERATE.equals(byCode.getSource())) {
            domainService.deleteDomainAndProp(byCode.getDomainCode());
        }
    }


    @Override
    public void delete(CgConfigTableFieldEntity entity) {
        JPAUtil.remove(entity);
    }

    @Override
    public void delete(List<String> ids) {
        ids.stream().forEach(item->{
            JPAUtil.remove(CgConfigTableFieldEntity.class,item);
        });
    }

    @Override
    public void update(CgConfigTableFieldEntity entity) {
        JPAUtil.update(entity);
    }

    @Override
    public CgConfigTableFieldVO getById(String tableId) {
        CgConfigTableFieldVO vo = new CgConfigTableFieldVO();
        CgConfigTableFieldEntity ety = JPAUtil.loadById(CgConfigTableFieldEntity.class, tableId);
        CommonBeanUtil.copyProperties(ety,vo);
        return vo;
    }
}
