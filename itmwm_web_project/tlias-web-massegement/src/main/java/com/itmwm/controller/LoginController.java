package com.itmwm.controller;

import com.itmwm.pojo.Emp;
import com.itmwm.pojo.Result;
import com.itmwm.service.EmpService;
import com.itmwm.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
public class LoginController {

  @Autowired
  private EmpService empService;

  @PostMapping("/login")
  public Result login(@RequestBody Emp emp) {
	log.info("员工登录: {}", emp);
	Emp e = empService.login(emp);
	if(e != null) {
	  HashMap<String , Object> claims = new HashMap<>();
	  claims.put("id", e.getId());
	  claims.put("username", e.getUsername());
	  String jwt = JwtUtils.generateJwt(claims);
	  return  Result.success(jwt);
	}
	return  Result.error("用户名或密码错误");
  }
}
