package com.itmwm.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class DemoFilter implements Filter {
  // 初始化
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
	System.out.println("init 初始化方法执行了");
	Filter.super.init(filterConfig);
  }

  // 拦截请求后调用
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	System.out.println("拦截到了请求");
	// 放行
	filterChain.doFilter(servletRequest, servletResponse);

	// 放行后的执行逻辑
	System.out.println("放行后的执行逻辑");
  }

  // 销毁
  @Override
  public void destroy() {
	System.out.println("destroy 销毁方法执行了");
	Filter.super.destroy();
  }
}
