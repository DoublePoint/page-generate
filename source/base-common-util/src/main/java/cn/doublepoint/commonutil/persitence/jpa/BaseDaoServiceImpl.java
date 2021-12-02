/** 
* 创   建   人： 刘磊
* 
* 创   建   时   间 ： 2018年5月12日
* 
* 类   说   明 ：
* 
* 修   改   人：          修   改   日   期：
*/
package cn.doublepoint.commonutil.persitence.jpa;

import java.beans.PropertyDescriptor;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.doublepoint.dto.domain.model.entity.BaseModel;
import cn.doublepoint.dto.domain.model.vo.query.PageInfo;
import cn.doublepoint.dto.domain.model.vo.query.QueryParam;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.dto.domain.model.vo.query.SortParamList;

@Service(value = "daoService")
public class BaseDaoServiceImpl implements BaseDaoService {
	@PersistenceContext
	private EntityManager em;

	public <T extends BaseModel> T loadById(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}

	@Override
	public <T extends BaseModel> List<Long> getNextVal(Class<T> clazz, int count) {
		return null;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	@Override
	public <T extends BaseModel> List<T> load(Class<T> clazz, QueryParamList paramsList, PageInfo pageInfo,
			SortParamList sortParamList) {
		try {
			String className = clazz.getName();
			StringBuffer jpqlFromBuffer = new StringBuffer("SELECT U  FROM " + className + " U WHERE 1=1 ");
			if (paramsList != null) {
				paramsList.getParams().stream().forEach(param -> {
					if (param.getRelation() != QueryParam.RELATION_ISNULL
							&& param.getRelation() != QueryParam.RELATION_NOTNULL) {
						jpqlFromBuffer.append(" AND U.").append(param.getName()).append(" ").append(param.getRelation())
								.append(" ").append(":" + param.getName());
					} else
						jpqlFromBuffer.append(" AND U.").append(param.getName()).append(" ")
								.append(param.getRelation());

				});
			}

			int firstIndex = -1;
			int lastIndex = -1;
			if (pageInfo != null) {
				long count = count(jpqlFromBuffer.toString(), paramsList);
				pageInfo.setTotalElementCount(count);
				firstIndex = getFirstResult(pageInfo);
				lastIndex = getMaxRsults(pageInfo);
			}

			StringBuffer queryBuffer = new StringBuffer();
			queryBuffer.append(jpqlFromBuffer);
			if (sortParamList != null) {
				queryBuffer.append(" order by ");
				sortParamList.getParams().stream().forEach(param -> {
					queryBuffer.append(" U.").append(param.getSortProperty()).append(" ").append(param.getSortType())
							.append(",");
				});
				queryBuffer.deleteCharAt(queryBuffer.length() - 1);
			}
			Query query = em.createQuery(queryBuffer.toString());
			if (firstIndex != -1 && lastIndex != -1) {
				query.setFirstResult(getFirstResult(pageInfo));
				query.setMaxResults(getMaxRsults(pageInfo));
			}
			if (paramsList != null) {
				paramsList.getParams().stream().forEach(param -> {
					if (param.getRelation() != QueryParam.RELATION_ISNULL
							&& param.getRelation() != QueryParam.RELATION_NOTNULL) {
						query.setParameter(param.getName(), param.getValue());
					}
				});
			}
			List<T> list = query.getResultList();

			em.clear();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Transactional
	@Override
	public <T extends BaseModel> void remove(Class<T> clazz, Object id) {
		T t = em.find(clazz, id);
		em.remove(t);
	}

	@Transactional
	@Override
	public <T extends BaseModel> void saveOrUpdate(T model) {
		em.merge(model);
	}

	@Transactional
	@Override
	public <T extends BaseModel> void saveOrUpdate(List<T> list) {
		list.stream().forEach(model -> {
			saveOrUpdate(model);
		});
	}

	@Override
	@Transactional
	public int executeUpdate(String jpql, QueryParamList queryParamList) {
		Query query = em.createQuery(jpql);
		
		if(queryParamList!=null){
			queryParamList.getParams().stream().forEach(param -> {
				query.setParameter(param.getName(), param.getValue());
			});
		}
		int result = query.executeUpdate();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public  List<Object> executeQuery(String jpql, QueryParamList queryParamList,PageInfo pageInfo) {
		Query query = em.createQuery(jpql);
		
		if(queryParamList!=null){
			queryParamList.getParams().stream().forEach(param -> {
				query.setParameter(param.getName(), param.getValue());
			});
		}
		if (pageInfo != null) {
			long count= count(jpql, queryParamList);
			pageInfo.setTotalElementCount(count);
			query.setFirstResult(getFirstResult(pageInfo));
			query.setMaxResults(getMaxRsults(pageInfo));
		}
		List<Object> result = query.getResultList();
		return result;
	}
	
	@Override
	public int executeNativeUpdate(String sql, QueryParamList queryParamList) {
		Query query = em.createNativeQuery(sql);

		queryParamList.getParams().stream().forEach(param -> {
			query.setParameter(param.getName(), param.getValue());
		});
		int result = query.executeUpdate();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public  List<Object> executeNativeQuery(String sql, QueryParamList queryParamList,PageInfo pageInfo) {
		Query query = em.createNativeQuery(sql);
		if(queryParamList!=null){
			queryParamList.getParams().stream().forEach(param -> {
				query.setParameter(param.getName(), param.getValue());
			});
		}
		
		if (pageInfo != null) {
			long count = countSql(sql, queryParamList);
			pageInfo.setTotalElementCount(count);
			query.setFirstResult(getFirstResult(pageInfo));
			query.setMaxResults(getMaxRsults(pageInfo));
		}
		List<Object> result = query.getResultList();
		return result;
	}

	/**
	 * 更具查询条件和查询参数 获取结果总数
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public long count(String jpql, QueryParamList queryParamList) {
		
		String sql=JPQLConverterUtil.convertJPQLToSQL(jpql,em);
		return countSql(sql,queryParamList);
	}
	
	/**
	 * 更具查询条件和查询参数 获取结果总数
	 * 
	 * @param sql
	 * @param queryParamList
	 * @return
	 */
	public long countSql(String sql, QueryParamList queryParamList) {
		
		StringBuffer countBuffer = new StringBuffer("Select count(1) FROM (" + sql).append(") ll_c_t");
		Query countQuery = em.createNativeQuery(countBuffer.toString());
		
		if (queryParamList != null) {
			queryParamList.getParams().stream().forEach(param -> {
				if (param.getRelation() != QueryParam.RELATION_ISNULL
						&& param.getRelation() != QueryParam.RELATION_NOTNULL) {
					countQuery.setParameter(param.getName(), param.getValue());
				}
			});
		}
		
		
		Object object=countQuery.getSingleResult();
		return ((BigInteger )object).longValue();
	}

	/**
	 * 更具查询条件和查询参数 获取结果总数
	 * 
	 * @param clazz
	 * @param paramsList
	 * @return
	 */
	public <T extends BaseModel> long count(Class<T> clazz, QueryParamList paramsList) {
		String className = clazz.getName();
		StringBuffer jpqlFromBuffer = new StringBuffer("SELECT U FROM " + className + " U WHERE 1=1 ");
		if (paramsList != null) {
			paramsList.getParams().stream().forEach(param -> {
				if (param.getRelation() != QueryParam.RELATION_ISNULL
						&& param.getRelation() != QueryParam.RELATION_NOTNULL) {
					jpqlFromBuffer.append(" AND U.").append(param.getName()).append(" ").append(param.getRelation())
							.append(" ").append(":" + param.getName());
				} else
					jpqlFromBuffer.append(" AND U.").append(param.getName()).append(" ").append(param.getRelation());

			});
		}
		return count(jpqlFromBuffer.toString(), paramsList);
	}
	
	@Override
	@Transactional
	public <T extends BaseModel> void create(T t) {
		em.persist(t);
	}
	
	@Override
	@Transactional
	public <T extends BaseModel> void create(List<T> list) {
		list.forEach(t->create(t));
	}

	@Override
	@Transactional
	public <T extends BaseModel> void update(T t) {
		em.merge(t);
	}
	
	@Override
	@Transactional
	public <T extends BaseModel> void update(List<T> list) {
		list.forEach(t->update(t));
	}

	@Override
	public Map.Entry<String,EntityPersister> getEntityClass(String tableCode){
		EntityManager em = getEm();
		EntityManagerFactory entityManagerFactory = em.getEntityManagerFactory();
		SessionFactoryImpl sessionFactory = (SessionFactoryImpl)entityManagerFactory.unwrap(SessionFactory.class);
		Map<String, EntityPersister> persisterMap = sessionFactory.getEntityPersisters();
		for(Map.Entry<String,EntityPersister> entity : persisterMap.entrySet()){
			Class targetClass = entity.getValue().getMappedClass();
			SingleTableEntityPersister persister = (SingleTableEntityPersister)entity.getValue();
			Iterable<AttributeDefinition> attributes = persister.getAttributes();
			String entityName = targetClass.getSimpleName();//Entity的名称
			String tableName = persister.getTableName();//Entity对应的表的英文名
			if(tableName.equalsIgnoreCase(tableCode)){
				return entity;
			}
//			System.out.println("类名：" + entityName + " => 表名：" + tableName);
//
//			//属性
//			for(AttributeDefinition attr : attributes){
//				String propertyName = attr.getName(); //在entity中的属性名称
//				String[] columnName = persister.getPropertyColumnNames(propertyName); //对应数据库表中的字段名
//				String type = "";
//				PropertyDescriptor targetPd = BeanUtils.getPropertyDescriptor(targetClass, propertyName);
//				if(targetPd != null){
//					type = targetPd.getPropertyType().getSimpleName();
//				}
//				System.out.println("属性名：" + propertyName + " => 类型：" + type + " => 数据库字段名：" + columnName[0]);
//			}
		}
		return null;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	private int getFirstResult(PageInfo pageInfo) {
		int pageSize = (int) pageInfo.getPageSize();
		int pageNum = (int) pageInfo.getCurrentPageNum();
		return pageSize * (pageNum - 1);
	}

	private int getMaxRsults(PageInfo pageInfo) {
		return (int) pageInfo.getPageSize();
	}

}
