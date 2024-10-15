package com.itmwm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 请求处理类
@RestController
public class HelloController {
  @RequestMapping("/helloWorld")
  public String hello () {
	System.out.println("Hello World");
	return "Hello World";
  }

  @RequestMapping("/userDemo")
  public String user(@RequestParam(name = "name", required = false) String name) {
	System.out.println(name);
	return name;
  }
}
