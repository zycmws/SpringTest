package com.zyc.springtest.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通用访问数据库
 * @author zyc
 *
 */
public abstract class CommonService {
	@Autowired
	protected SqlSessionDaoSupport sqlSessionDaoSupport;
	
	/**
	 * 公共查询方法
	 * @param statement 格式如 TEST.QUERYTEST  为mybatis的xml配置文件里的 '表空间.id'
	 * @param map
	 * @return
	 */
	protected List<Map<String, Object>> commonQry(String statement, Object map)
	{
		List<Map<String, Object>> listMaps = null;
		listMaps = sqlSessionDaoSupport.getSqlSession().selectList(statement, map);
		return listMaps;
	}
	
	protected int commonInsert(String statement, Map<String, Object> map) {
		int succNum = 0;
		succNum = sqlSessionDaoSupport.getSqlSession().insert(statement, map);
		return succNum;
	}
	
	protected int commonUpdate(String statement, Map<String, Object> map) {
		int succNum = 0;
		succNum = sqlSessionDaoSupport.getSqlSession().update(statement, map);
		return succNum;
	}
	
	protected int commonDelete(String statement, Map<String, Object> map) {
		int succNum = 0;
		succNum = sqlSessionDaoSupport.getSqlSession().delete(statement, map);
		return succNum;
	}
}
