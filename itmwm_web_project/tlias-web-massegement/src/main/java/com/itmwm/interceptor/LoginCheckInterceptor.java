package com.itmwm.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.itmwm.pojo.Result;
import com.itmwm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器类
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
  @Override // 目标资源方法运行前运行 返回 ture 放行 false: 拦截
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	System.out.println("preHandle...");
	// 1. 获取请求的url
	String url = request.getRequestURL().toString();
	log.info("请求的url: {}", url);
	// 2. 判断 url 是否包含了 login 如果包含,说明是登录操作 放行
	if (url.contains("login")) {
	  log.info("登录操作放行");
	  return true;
	}
	// 3. 获取请求头中的令牌(token)
	String token = request.getHeader("token");

	// 4. 判断token是否存在
	if(!StringUtils.hasLength(token)) {
	  log.info("请求头token为空");
	  Result err = Result.error("NOT_LOGIN");
	  // 将对象转成json格式
	  String errJson = JSONObject.toJSONString(err);
	  response.getWriter().write(errJson); // 通过输出流响应数据
	  return false;
	}

	// 5. 解析 token 如果解析失败,返回结果未登录
	try {
	  Claims claims = JwtUtils.parseJWT(token);
	}catch (Exception e) {
	  e.printStackTrace(); // 输出报错日志
	  log.info("解析令牌失败, 返回错误信息");
	  Result err = Result.error("NOT_LOGIN");
	  // 将对象转成json格式
	  String errJson = JSONObject.toJSONString(err);
	  response.getWriter().write(errJson); // 通过输出流响应数据
	  return false;
	}

	log.info("token合法, 放行");
	return true;
  }

  @Override // 目标资源方法运行后运行
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	System.out.println("postHandle...");
	HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override // 视图渲染完毕运行后 运行
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	System.out.println("afterCompletion...");
	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
