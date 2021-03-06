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

            //??????????????????
            if(!StringUtils.isEmpty(entity.getDomainCode())){
                CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
                vo.setRelDefaultDomain(domainTree);
            }

            //??????????????????
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
            //??????????????????
            if(!StringUtils.isEmpty(entity.getDomainCode())){
                CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
                vo.setRelDefaultDomain(domainTree);
            }

            //??????????????????
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

        //??????DB??????????????????????????????????????????Domain????????????????????????????????????domain??????
        if(dbDomEmpty&&reuDomEmpty){
            CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
            cmd.setDomainCode(newDomain.getDomainCode());
            Log4jUtil.debug("Cmd has been changed,please use carefully.");
            propService.saveDomainProp(cmd);
            //??????????????????
            saveExtDomainCode(reuFieldId,newDomain.getDomainCode());
            //???????????????
            //clearDefaultDomainCode(cmd);
            return response;
        }
        //????????????????????????Domain,?????????????????????
        if(dbDomEmpty&&!reuDomEmpty){
            changeDefaultDomain(reuFieldId,reuDomainCode);
            //
            saveExtDomainProp(cmd);
        }
        //???????????????Domain?????????????????????????????????????????????????????????????????????????????????DB??????????????????????????????
        else if(!dbDomEmpty&&reuDomEmpty){
            CgDomainEntity dbDomain = domainDao.getByCode(dbDefaultDomainCode);
            //??????????????????????????????
            boolean isDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
            if(isDefault){
                CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
                cmd.setDomainCode(newDomain.getDomainCode());
                Log4jUtil.debug("Cmd has been changed,please use carefully.");
                propService.saveDomainProp(cmd);
                changeDefaultDomain(reuFieldId,newDomain.getDomainCode());
            }
            else{
                //???????????????
                propService.deleteByDomainCode(dbDefaultDomainCode);
                cmd.setDomainCode(dbDefaultDomainCode);
                propService.saveDomainProp(cmd);
            }
        }
        //??????DB Domain?????????Domain????????????
        else {
            CgDomainEntity dbDomain = domainDao.getByCode(dbDefaultDomainCode);
            CgDomainEntity reuDomain = domainDao.getByCode(reuDomainCode);
            boolean isDbDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
            boolean isResDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(reuDomain.getSource());
            //?????????????????????
            if(isDbDefault&&isResDefault) {
                //?????????????????????
                if(reuDomainCode.equals(dbDefaultDomainCode)){
                    Log4jUtil.warn("The domain code is same,will be ignore???");
                    return response;
                }
                else{
                    changeDefaultDomain(reuFieldId,reuDomainCode);
                }
            }
            //???????????????????????????
            else if (isDbDefault&&!isResDefault){
                //???????????????
                propService.deleteByDomainCode(reuDomainCode);
                cmd.setDomainCode(reuDomainCode);
                propService.saveDomainProp(cmd);
                changeDefaultDomain(reuFieldId,reuDomainCode);
            }
            else if(!isDbDefault&&isResDefault){
                deleteDomainAndProp(dbDefaultDomainCode);
                changeDefaultDomain(reuFieldId,reuDomainCode);
            }
            //????????????????????????
            else {
                //??????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                if(reuDomainCode.equals(dbDefaultDomainCode)){
                    propService.deleteByDomainCode(reuDomainCode);
                    cmd.setDomainCode(reuDomainCode);
                    propService.saveDomainProp(cmd);
                }
                //?????????????????????????????????????????????????????????????????????????????????????????????
                else{
                    deleteDomainAndProp(dbDefaultDomainCode);
                    CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
                    cmd.setDomainCode(newDomain.getDomainCode());
                    propService.saveDomainProp(cmd);
                    changeDefaultDomain(reuFieldId,newDomain.getDomainCode());
                }
            }
//            if(reuDomainCode.equals(dbDomainCode)){
//                Log4jUtil.warn("The domain code is same,will be ignore???");
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

        //?????????????????????
        if(reuDomEmpty){
            //???????????????
            clearDefaultDomainCode(reuFieldId);
            //????????????????????????
            saveExtDomainProp(cmd);

            if(!dbDomEmpty){
                CgDomainEntity dbDomain = domainDao.getByCode(dbDefaultDomainCode);
                //?????????????????????????????????,????????????????????????
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
     * ?????????????????????
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
     * ?????????????????????????????????????????????????????????????????????Field???????????????
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
     * ??????????????????????????????????????????????????????
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
