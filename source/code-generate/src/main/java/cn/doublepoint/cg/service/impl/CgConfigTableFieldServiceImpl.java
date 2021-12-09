package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.dao.CgTableFieldDao;
import cn.doublepoint.cg.dao.ICgDomainDao;
import cn.doublepoint.cg.domain.model.CgConfigTableFieldEntity;
import cn.doublepoint.cg.domain.model.CgDomainEntity;
import cn.doublepoint.cg.domain.vo.CgConfigTableFieldVO;
import cn.doublepoint.cg.domain.vo.CgDomainVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.domain.vo.SaveExtPropCmdVO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            if(StringUtils.isEmpty(entity.getDomainCode())){
                Map<String, CgObjectPropVO> props = propService.getTableConfigProps(entity.getId());
                vo.setRelObjectProp(props);
            }
            else{
                CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
                vo.setRelDomain(domainTree);
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
            if(!StringUtils.isEmpty(entity.getDomainCode())){
                CgDomainVO domainTree = domainService.getDomainTreeByCode(entity.getDomainCode());
                vo.setRelDomain(domainTree);
            }
            else{
                Map<String, CgObjectPropVO> props = propService.getTableConfigProps(entity.getId());
                vo.setRelObjectProp(props);
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
    public void changeDomainCode(String fieldId,String domainCode){
        if(StringUtils.isEmpty(fieldId)){
            Log4jUtil.warn("Field id cannot be null");
            return;
        }

        CgConfigTableFieldEntity fieldEty = JPAUtil.loadById(CgConfigTableFieldEntity.class, fieldId);

        fieldEty.setDomainCode(domainCode);
        JPAUtil.update(fieldEty);
    }

    @PostMapping("/field/prop")
    public AjaxResponse saveFieldExtendProp(@RequestBody SaveExtPropCmdVO cmd){
        AjaxResponse response = new AjaxResponse();

        CgConfigTableFieldEntity dbField = JPAUtil.loadById(CgConfigTableFieldEntity.class, cmd.getFieldId());

        String dbDomainCode = dbField.getDomainCode();
        String reuDomainCode = cmd.getDomainCode();
        String reuFieldId = cmd.getFieldId();
        boolean dbDomEmpty = org.apache.commons.lang.StringUtils.isEmpty(dbDomainCode);
        boolean reuDomEmpty = org.apache.commons.lang.StringUtils.isEmpty(reuDomainCode);

        //如果前后Domain都是空，则修改field的prop
        if(dbDomEmpty&&reuDomEmpty){
            response.setErrorMessage("The domain code annot be null.");
            return response;
        }
        //如果重置成了绑定Domain,处理删除原来的
        if(dbDomEmpty&&!reuDomEmpty){
            changeDomainCode(reuFieldId,reuDomainCode);
        }
        //如果数据库Domain不空，目的域是空的则，创建新域、绑定新域、创建属性如果DB域是自动生成的则删除
        else if(!dbDomEmpty&&reuDomEmpty){
            CgDomainEntity dbDomain = domainDao.getByCode(dbDomainCode);
            //如果数据库中是默认域
            boolean isDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
            if(isDefault){
                CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
                cmd.setDomainCode(newDomain.getDomainCode());
                Log4jUtil.debug("Cmd has been changed,please use carefully.");
                propService.saveDomainProp(cmd);
                changeDomainCode(reuFieldId,newDomain.getDomainCode());
            }
            else{
                //更新域属性
                propService.deleteByDomainCode(dbDomainCode);
                cmd.setDomainCode(dbDomainCode);
                propService.saveDomainProp(cmd);
            }
        }
        //如果DB Domain与结果Domain都不为空
        else {
            CgDomainEntity dbDomain = domainDao.getByCode(dbDomainCode);
            CgDomainEntity reuDomain = domainDao.getByCode(reuDomainCode);
            boolean isDbDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(dbDomain.getSource());
            boolean isResDefault = CgConstant.DOMAIN_SOURCE_DEFAULT.equals(reuDomain.getSource());
            //如果都是默认域
            if(isDbDefault&&isResDefault) {
                //如果前后域相等
                if(reuDomainCode.equals(dbDomainCode)){
                    Log4jUtil.warn("The domain code is same,will be ignore，");
                    return response;
                }
                else{
                    changeDomainCode(reuFieldId,reuDomainCode);
                }
            }
            //如果结果不是默认域
            else if (isDbDefault&&!isResDefault){
                //更新域属性
                propService.deleteByDomainCode(reuDomainCode);
                cmd.setDomainCode(reuDomainCode);
                propService.saveDomainProp(cmd);
                changeDomainCode(reuFieldId,reuDomainCode);
            }
            else if(!isDbDefault&&isResDefault){
                deleteDomainAndProp(dbDomainCode);
                changeDomainCode(reuFieldId,reuDomainCode);
            }
            //如果都不是默认域
            else {
                //如果前后域一致，代表每发生变化，只是修改了属性值，则删除原来属性，添加新属性
                if(reuDomainCode.equals(dbDomainCode)){
                    propService.deleteByDomainCode(reuDomainCode);
                    cmd.setDomainCode(reuDomainCode);
                    propService.saveDomainProp(cmd);
                }
                //否则删除原来的属性和域，添加新的属性，添加新的域，改变关联关系
                else{
                    deleteDomainAndProp(dbDomainCode);
                    CgDomainEntity newDomain = domainService.createNewDomainByFieldId(cmd.getFieldId());
                    cmd.setDomainCode(newDomain.getDomainCode());
                    propService.saveDomainProp(cmd);
                    changeDomainCode(reuFieldId,newDomain.getDomainCode());
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
