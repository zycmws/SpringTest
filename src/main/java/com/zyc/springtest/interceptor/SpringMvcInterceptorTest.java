package com.zyc.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 实现HandlerInterceptor接口，
 * 通过xml配置的spring拦截器实现
 * @author zyc
 *
 */
public class SpringMvcInterceptorTest implements HandlerInterceptor{
	private static final Logger log = Logger.getLogger(SpringMvcInterceptorTest.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		log.info("Handle执行之后，生成视图之后执行:一般用于释放资源");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		log.info("Handle执行之后，生成视图之前执行");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		log.info("Handle之前执行");
		return true;//继续执行action
	}

}
