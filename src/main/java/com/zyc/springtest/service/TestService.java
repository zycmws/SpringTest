package com.zyc.springtest.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 测试service
 * @author zyc
 *
 */
@Service("testService")
public class TestService extends CommonService {
	
	/**
	 * 查询测试
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryTest(Object map) throws Exception{
		try{
			String service_code ="TEST.QUERYTEST";
			return commonQry(service_code,map);
		}catch(Exception e){
			throw new Exception(this.getClass().toString(),e);
		}
	}
	public int insertTest(Map<String, Object> map) throws Exception {
		try{
			String service_code ="TEST.INSERTTEST";
			return commonInsert(service_code,map);
		}catch(Exception e){
			throw new Exception(this.getClass().toString(),e);
		}
	}
	
	public int updateTest(Map<String, Object> map) throws Exception {
		try{
			String service_code ="TEST.UPDATETEST";
			return commonUpdate(service_code,map);
		}catch(Exception e){
			throw new Exception(this.getClass().toString()+e,e);
		}
	}
	
	public int deleteTest(Map<String, Object> map) throws Exception {
		try{
			String service_code ="TEST.DELETETEST";
			return commonDelete(service_code,map);
		}catch(Exception e){
			throw new Exception(this.getClass().toString(),e);
		}
	}
}
