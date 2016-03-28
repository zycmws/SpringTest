package com.zyc.springtest.servlet;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.pages.PageMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyc.springtest.service.TestService;
/**
 * 测试Servlet
 * @author zyc
 *
 */
@Controller
@RequestMapping("TestServlet")
public class TestServlet{
	public TestServlet() {
		
	}
	@Autowired
	public TestService testService;
	
	@RequestMapping("queryTest.action")
	public void queryTest(HttpServletRequest request,HttpServletResponse response) {	
		/*Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", "2");*/
		try {
			PageMap<Object> pm = new PageMap<Object>();
			pm.setPageSize(2);
			pm.setStartNum(0);
			pm.put("id", "2");
			List<Map<String, Object>> list = testService.queryTest(pm);
			Map<String,Object> responseMap = new HashMap<String,Object>();
			if(null!=pm){
				responseMap.put("totalPage", pm.getTotalPage());
				responseMap.put("pageIndex", pm.getStartNum());
				responseMap.put("totalRecord", pm.getTotalRecord());
			}
			responseMap.put("dataList", list);
			PrintWriter out = response.getWriter();
			out.println(JSONObject.toJSONString(responseMap));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
