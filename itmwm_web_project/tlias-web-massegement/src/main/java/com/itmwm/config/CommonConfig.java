package com.itmwm.config;

import com.itmwm.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 将第三方的(不是自己定义的), 是无法使用@Component以及衍生注解声明的bean, 需要用到 @Bean 注解
@Configuration // 配置类 在jar包运行时, 会自动运行配置类调用里面的方法,不需要写到入口文件中
public class CommonConfig {

  @Bean // 将当前方法的返回值对象交给IOC容器管理, 成为IOC容器bean
  public SAXReader saxReader (DeptService deptService) {
	System.out.println(deptService); // 依赖注入
	return new SAXReader();
  }
}
