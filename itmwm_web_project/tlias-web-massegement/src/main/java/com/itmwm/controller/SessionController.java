package com.itmwm.controller;

import com.itmwm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class SessionController {

  @GetMapping("/c1")
  public Result cookie1(HttpServletResponse response) {
	response.addCookie(new Cookie("login_username", "MwM-Mai"));
	return Result.success();
  }


  @GetMapping("/c2")
  public Result cookie2(HttpServletRequest request) {
	Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
	  if(cookie.getName().equals("login_username")) {
		log.info("login_username: {}", cookie.getValue());
	  }
	}
	return Result.success();
  }
  
  @GetMapping("/s1")
  public Result session1(HttpSession session) {
	log.info("HttpSession-s1: {}", session.hashCode());
	
	session.setAttribute("loginUser", "MwM-Mai");
	return  Result.success();
  }
  
  @GetMapping("/s2")
  public Result session2(HttpServletRequest request) {
	HttpSession session = request.getSession();
	log.info("HttpSession-s2: {}", session.hashCode());
	Object loginUser = session.getAttribute("loginUser");
	log.info("loginUser: {}", loginUser);
	return Result.success(loginUser);
  }
}
