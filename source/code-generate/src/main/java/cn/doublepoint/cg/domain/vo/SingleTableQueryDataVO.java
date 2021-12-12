package cn.doublepoint.cg.domain.vo;

import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.commonutil.persitence.jpa.JPAUtil;
import cn.doublepoint.dto.domain.model.entity.BaseEntity;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.persister.entity.EntityPersister;

import java.util.Map;

public class SingleTableQueryDataVO {

    private String tableCode;
    private QueryParamList queryParamList;

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public QueryParamList getQueryParamList() {
        return queryParamList;
    }

    public void setQueryParamList(QueryParamList queryParamList) {
        this.queryParamList = queryParamList;
    }

}
