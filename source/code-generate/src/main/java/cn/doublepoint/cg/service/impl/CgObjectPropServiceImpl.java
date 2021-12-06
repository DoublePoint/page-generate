package cn.doublepoint.cg.service.impl;

import cn.doublepoint.cg.dao.ICgObjectPropDao;
import cn.doublepoint.cg.domain.model.CgMetaComPropEntity;
import cn.doublepoint.cg.domain.model.CgObjectPropEntity;
import cn.doublepoint.cg.domain.vo.CgMetaComPropVO;
import cn.doublepoint.cg.domain.vo.CgObjectPropVO;
import cn.doublepoint.cg.domain.vo.SaveExtPropCmdSubVO;
import cn.doublepoint.cg.domain.vo.SaveExtPropCmdVO;
import cn.doublepoint.cg.service.CgObjectPropService;
import cn.doublepoint.cg.util.CgConstant;
import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.jpa.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created on 2021/12/1.
 *
 * @author DoublePoint
 */
@Service
public class CgObjectPropServiceImpl implements CgObjectPropService {
    @Autowired
    ICgObjectPropDao objectPropDao;

    @Override
    public void save(List<CgObjectPropEntity> list) {
        objectPropDao.save(list);
    }

    @Override
    public Map<String,CgObjectPropVO> getProps(String code){
        return getDominPropsValue(code, CgConstant.OBJECT_PROP_REL_TYPE_VUECOMPONENT);
    }

    private Map<String,CgObjectPropVO> getDominPropsValue(String code,String objectType){
        Map<String,CgObjectPropVO> map = new HashMap<>();
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT r,p FROM CgObjectPropEntity r,CgMetaComPropEntity p WHERE " );
        sb.append(" r.objectType = :objectType and r.propCode = p.propCode  ");
        sb.append(" AND r.objectCode=:domainCode");

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("domainCode", code);
        paramList.addParam("objectType",objectType);

        List<Object> list = JPAUtil.executeQuery(sb.toString(), paramList);
        list.stream().forEach(item->{
            Object[] arr = (Object[]) item;
            CgObjectPropEntity propEntity = (CgObjectPropEntity)arr[0];
            CgMetaComPropEntity metaPropEntity = (CgMetaComPropEntity)arr[1];

            CgObjectPropVO vo = new CgObjectPropVO();
            CommonBeanUtil.copyProperties(propEntity, vo);
            CgMetaComPropVO metaProp = new CgMetaComPropVO();
            CommonBeanUtil.copyProperties(metaPropEntity, metaProp);
            vo.setMetaProp(metaProp);

            map.put(metaProp.getPropName(),vo);
        });
        return map;
    }

    private Map<String,CgObjectPropVO> getFieldPropsValue(String code,String objectType){
        Map<String,CgObjectPropVO> map = new HashMap<>();
        StringBuffer sb = new StringBuffer("");

        sb.append("SELECT r FROM CgObjectPropEntity r WHERE " );
        sb.append(" r.objectType = :objectType  ");
        sb.append(" AND r.objectCode=:domainCode");

        QueryParamList paramList = new QueryParamList();
        paramList.addParam("domainCode", code);
        paramList.addParam("objectType",objectType);

        List<CgObjectPropVO> list = JPAUtil.executeQueryModel(sb.toString(), paramList,CgObjectPropVO.class);
        list.stream().forEach(item->{
            map.put(item.getPropCode(),item);
        });
        return map;
    }


    @Override
    public Map<String, CgObjectPropVO> getTableConfigProps(String code) {
        return getFieldPropsValue(code, CgConstant.OBJECT_PROP_REL_TYPE_CONFIG_TABLE_FIELD);
    }

    /**
     * 保存字段属性，没有的创建，有的更新
     * @param cmd
     */
    @Override
    public void saveFieldProp(SaveExtPropCmdVO cmd) {
        if(cmd==null){
            Log4jUtil.error(new Exception("Save Field Extend Prop Command is empty."));
            return ;
        }
        List<SaveExtPropCmdSubVO> propList = cmd.getProp();
        if(CollectionUtils.isEmpty(propList)){
            Log4jUtil.warn("Prop is empty");
            return;
        }
        final String fieldId = cmd.getFieldId();
        List<CgObjectPropEntity> createList = new ArrayList<>();
        List<CgObjectPropEntity> updateList = new ArrayList<>();
        propList.stream().forEach(item->{
            final String propCode = item.getPropCode();
            final String propValue = item.getPropValue();
            CgObjectPropEntity prop = objectPropDao.getObjectObjectcodePropcode(fieldId, item.getPropCode());
            if(prop == null){
                CgObjectPropEntity ety = new CgObjectPropEntity();
                ety.setPropCode(propCode);
                ety.setPropValue(propValue);
                ety.setObjectCode(fieldId);
                ety.setObjectType(CgConstant.OBJECT_PROP_REL_TYPE_CONFIG_TABLE_FIELD);
                createList.add(ety);
            }
            else{
                prop.setPropValue(propValue);
                updateList.add(prop);
            }
        });

        objectPropDao.create(createList);
        objectPropDao.update(updateList);
    }

    @Override
    public void deleteByFieldId(String fieldId) {
        QueryParamList paramList = new QueryParamList();
        paramList.addParam("fieldId",fieldId);
        paramList.addParam("objectType",CgConstant.OBJECT_PROP_REL_TYPE_CONFIG_TABLE);
        JPAUtil.executeUpdate("DELETE FROM CgObjectPropEntity WHERE objectCode = :fieldId and objectType=:objectType",paramList);
    }
}
