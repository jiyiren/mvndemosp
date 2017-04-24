package com.jiyiren.mvnspdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Session拦截器
 * @author  yiji
 * @version v1.0
 * @date    2017年4月23日 下午1:22:23
 * @Description 
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		String uri=request.getRequestURI();
		System.out.println("uri:"+uri);
		if(uri.contains("login")||uri.contains("register")){
			if(request.getSession().getAttribute("user")!=null){
				response.sendRedirect(request.getContextPath()+"/index");
			}else{
				return true;
			}
		}
		if(request.getSession().getAttribute("user")!=null){
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}

}
