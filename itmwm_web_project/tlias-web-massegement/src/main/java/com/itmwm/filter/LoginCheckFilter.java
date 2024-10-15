package com.itmwm.filter;

import com.alibaba.fastjson2.JSONObject;
import com.itmwm.pojo.Result;
import com.itmwm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter
public class LoginCheckFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) servletRequest; // 强转为 HttpServletRequest 类型
	HttpServletResponse res = (HttpServletResponse) servletResponse;

	// 1. 获取请求的url
	String url = req.getRequestURL().toString();
	log.info("请求的url: {}", url);
	// 2. 判断 url 是否包含了 login 如果包含,说明是登录操作 放行
	if (url.contains("login")) {
	  log.info("登录操作放行");
	  filterChain.doFilter(servletRequest, servletResponse);
	  return;
	}
	// 3. 获取请求头中的令牌(token)
	String token = req.getHeader("token");

	// 4. 判断token是否存在
	if(!StringUtils.hasLength(token)) {
	  log.info("请求头token为空");
	  Result err = Result.error("NOT_LOGIN");
	  // 将对象转成json格式
	  String errJson = JSONObject.toJSONString(err);
	  res.getWriter().write(errJson); // 通过输出流响应数据
	  return;
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
	  res.getWriter().write(errJson); // 通过输出流响应数据
	  return;
	}

	log.info("token合法, 放行");
	filterChain.doFilter(servletRequest, servletResponse);
  }
}
