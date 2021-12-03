/** 
* 创   建   人： 刘磊
* 
* 创   建   时   间 ： 2017年10月14日
* 
* 类   说   明 ：查询菜单服务
* 
* 修   改   人：          修   改   日   期：
*/
package cn.doublepoint.commonutil.persitence.jpa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Id;

import cn.doublepoint.commonutil.domain.model.CommonBeanUtil;
import cn.doublepoint.commonutil.log.Log4jUtil;
import cn.doublepoint.dto.domain.model.entity.BaseModel;
import cn.doublepoint.dto.domain.model.vo.query.PageInfo;
import cn.doublepoint.dto.domain.model.vo.query.QueryParamList;
import cn.doublepoint.dto.domain.model.vo.query.SortParamList;

public class JPAUtil extends DataBaseUtil {
	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public static <T extends BaseModel> T loadById(Class<T> clazz, Object id) {
		BaseDaoService daoService = getDaoService();
		
		return daoService.loadById(clazz, id);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param queryParamList
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, QueryParamList queryParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, queryParamList, null, null);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param pageInfo
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, PageInfo pageInfo) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, null, pageInfo, null);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param sortParamList
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, SortParamList sortParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, null, null, sortParamList);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param queryParamList
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, QueryParamList queryParamList, PageInfo pageInfo) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, queryParamList, pageInfo, null);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param queryParamList
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, QueryParamList queryParamList,
			SortParamList sortParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, queryParamList, null, sortParamList);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param pageInfo
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, PageInfo pageInfo, SortParamList sortParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, null, pageInfo, sortParamList);
	}

	/**
	 * 获取实体信息
	 * 
	 * @param clazz
	 * @param queryParamList
	 * @return
	 */
	public static <T extends BaseModel> List<T> load(Class<T> clazz, QueryParamList queryParamList, PageInfo pageInfo,
			SortParamList sortParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, queryParamList, pageInfo, sortParamList);
	}

	public static <T extends BaseModel> List<T> loadAll(Class<T> clazz) {
		BaseDaoService daoService = getDaoService();
		return daoService.load(clazz, null, null, null);
	}

	/**
	 * 删除列表
	 * 
	 * @param list
	 */
	public static <T extends BaseModel> void remove(List<T> list) {
		if (list == null || list.size() == 0) {
			return;
		}
		list.stream().forEach(JPAUtil::remove);
	}

	/**
	 * 保存
	 * 
	 * @param t
	 */
	public static <T extends BaseModel> void saveOrUpdate(T t) {
		BaseDaoService daoService = getDaoService();
		daoService.saveOrUpdate(t);
	}

	/**
	 * 保存
	 * 
	 * @param list
	 */
	public static <T extends BaseModel> void saveOrUpdate(List<T> list) {
		BaseDaoService daoService = getDaoService();
		daoService.saveOrUpdate(list);
	}

	/**
	 * 根据id删除
	 * 
	 * @param clazz
	 * @param id
	 */
	public static <T extends BaseModel> void remove(Class<T> clazz, Object id) {
		BaseDaoService daoService = getDaoService();
		daoService.remove(clazz, id);
	}

	/**
	 * 根据id删除
	 * 
	 * @param model
	 */
	public static <T extends BaseModel> void remove(T model) {
		BaseDaoService daoService = getDaoService();
		try {
			daoService.remove(model.getClass(), getPrimary(model));
		} catch (IllegalArgumentException e) {
			Log4jUtil.error(e);
			throw (e);
		}
	}

	/**
	 * 查询总数
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T extends BaseModel> long count(Class<T> clazz) {
		BaseDaoService daoService = getDaoService();
		return daoService.count(clazz, null);
	}

	/**
	 * 查询总数
	 * 
	 * @param clazz
	 * @param queryParamList
	 * @return
	 */
	public static <T extends BaseModel> long count(Class<T> clazz, QueryParamList queryParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.count(clazz, queryParamList);
	}

	/**
	 * 查询总数
	 * 
	 * @param jpql
	 * @return
	 */
	public static <T extends BaseModel> long count(String jpql) {
		BaseDaoService daoService = getDaoService();
		return daoService.count(jpql, null);
	}

	/**
	 * 查询总数
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public static <T extends BaseModel> long count(String jpql, QueryParamList queryParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.count(jpql, queryParamList);
	}

	public static <T extends BaseModel> void create(T t) {
		BaseDaoService daoService = getDaoService();
		daoService.create(t);
	}

	public static <T extends BaseModel> void create(List<T> list) {
		BaseDaoService daoService = getDaoService();
		daoService.create(list);
	}

	public static <T extends BaseModel> void update(T t) {
		BaseDaoService daoService = getDaoService();
		daoService.update(t);
	}

	public static <T extends BaseModel> void update(List<T> list) {
		BaseDaoService daoService = getDaoService();
		daoService.update(list);
	}

	/**
	 * 执行更新或删除语句
	 * 
	 * @param jpql
	 * @return
	 */
	public static int executeUpdate(String jpql) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeUpdate(jpql, null);
	}

	/**
	 * 执行更新或删除语句
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public static int executeUpdate(String jpql, QueryParamList queryParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeUpdate(jpql, queryParamList);
	}

	/**
	 * JPQL方式执行更新或删除语句
	 * 
	 * @param jpql
	 * @return
	 */
	public static List<Object> executeQuery(String jpql) {
		return executeQuery(jpql, null, null);
	}

	/**
	 * JPQL方式执行查询
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public static List<Object> executeQuery(String jpql, QueryParamList queryParamList) {
		return executeQuery(jpql, queryParamList, null);
	}

	/**
	 * JPQL方式执行查询
	 * 
	 * @param jpql
	 * @param pageInfo
	 * @return
	 */
	public static List<Object> executeQuery(String jpql, PageInfo pageInfo) {
		return executeQuery(jpql, null, pageInfo);
	}

	/**
	 * JPQL方式执行查询
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public static List<Object> executeQuery(String jpql, QueryParamList queryParamList, PageInfo pageInfo) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeQuery(jpql, queryParamList, pageInfo);
	}

	/**
	 * JPQL方式执行更新或删除语句
	 * 
	 * @param jpql
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> executeQueryModel(String jpql, Class<T> clazz) {
		return executeQueryModel(jpql, null, null, clazz);
	}

	/**
	 * JPQL方式执行查询
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public static <T> List<T> executeQueryModel(String jpql, QueryParamList queryParamList, Class<T> clazz) {
		return executeQueryModel(jpql, queryParamList, null, clazz);
	}

	/**
	 * JPQL方式执行查询
	 * 
	 * @param jpql
	 * @param pageInfo
	 * @return
	 */
	public static <T> List<T> executeQueryModel(String jpql, PageInfo pageInfo, Class<T> clazz) {
		return executeQueryModel(jpql, null, pageInfo, clazz);
	}

	/**
	 * JPQL方式执行查询
	 * 
	 * @param jpql
	 * @param queryParamList
	 * @return
	 */
	public static <T> List<T> executeQueryModel(String jpql, QueryParamList queryParamList, PageInfo pageInfo,
			Class<T> clazz) {
		BaseDaoService daoService = getDaoService();
		List<Object> objects = daoService.executeQuery(jpql, queryParamList, pageInfo);
		if(objects.size()==0) {
			return new ArrayList<T>();
		}
		return CommonBeanUtil.copyTo(objects, clazz);
	}

	/**
	 * 执行更新或删除语句
	 * 
	 * @param sql
	 * @return
	 */
	public static int executeNativeUpdate(String sql) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeNativeUpdate(sql, null);
	}

	/**
	 * 执行更新或删除语句
	 * 
	 * @param sql
	 * @param queryParamList
	 * @return
	 */
	public static int executeNativeUpdate(String sql, QueryParamList queryParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeNativeUpdate(sql, queryParamList);
	}

	/**
	 * SQL方式执行更新或删除语句
	 * 
	 * @param sql
	 * @return
	 */
	public static List<Object> executeNativeQuery(String sql) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeNativeQuery(sql, null, null);
	}

	/**
	 * SQL方式执行查询
	 * 
	 * @param sql
	 * @param queryParamList
	 * @return
	 */
	public static List<Object> executeNativeQuery(String sql, QueryParamList queryParamList) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeNativeQuery(sql, queryParamList, null);
	}
	
	/**
	 * SQL方式执行查询
	 * 
	 * @param sql
	 * @param queryParamList
	 * @return
	 */
	public static List<Object> executeNativeQuery(String sql, QueryParamList queryParamList,PageInfo pageInfo) {
		BaseDaoService daoService = getDaoService();
		return daoService.executeNativeQuery(sql, queryParamList, pageInfo);
	}

	private static <T extends BaseModel> Object getPrimary(T model) {
		try {
			Field[] fields = model.getClass().getDeclaredFields();
			Field res = Stream.of(fields).filter(field -> {
				field.setAccessible(true);
				return (field.getAnnotation(Id.class) != null);
			}).findAny().get();
			return res.get(model);
		}
		catch (Exception e){
			Log4jUtil.error(e);
			try {
				Method[] methods = model.getClass().getDeclaredMethods();
				Method met = Stream.of(methods).filter(method -> {
					return (method.getAnnotation(Id.class) != null);
				}).findAny().get();
				return met.invoke(model);
			}
			catch (Exception e2){
				e2.printStackTrace();
				Log4jUtil.error(e2);
			}
		}

		return null;
	}

}
