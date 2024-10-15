# 1.三层架构

##### 	controller -> service -> dao

​	controller层: 接收请求、响应请求

​	service层: 处理逻辑数据

​	dao层: 数据访问(文件数据、数据库数据、第三方接口数据等)

# 2. 分层解耦 IOC & DI

@Component :  将当前类交给IOC容器管理, 成为IOC容器中的bean对象

@Autowired:  运行时 IOC 容器会提供 该类型的bean对象并赋值给该对象

1.  将Servie层 及 dao层的实现类, 交给 IOC容器管理(注解 @Component)
2. 为 Controller 及 Service 注入运行时依赖对象(注解 @Autowired)
3. 运行测试

#### DI 详情

###### 1. 可以在 注解 @Autowired 前加 @Qualifier("bean") 指定某个IOC容器中的对象

###### 2. 使用 注解 @Resource(name="component")

#### @Autowired 和 @Resource 的区别

###### 1. @Autowired 是SpringBoot框架提供的注解, 而 @Resource 是jdk提供的注解

###### 2. @Autowired 默认是按照类型注入, 而 @Resoured默认是按照名称注入

# 3.MySQl 事务的四大特性(ACID)

##### 事务: 是一组操作的集合,这组集合要么全部成功,要么全部失败

原子性: 事务是不可分割的最小单元,要么全部成功,要么全部失败

一致性: 事务完成时, 必须使所有的数据都保存一直状态

隔离性: 数据库系统提供的隔离机制,保证事务在不受外部并发操作影响的独立环境允许

持久性: 事务一旦提交或回滚,它对数据库中的数据的改变就是永久性的

# 4. MySQL 数据库查询的优化(索引)

##### 索引: 帮助数据库高效获取数据的数据结构

```mysql
 -- 创建索引
 create index 索引名 on 表名(字段);
 
 -- 查询索引
 show index form 表名;
 
 -- 删除所有
 drop index 索引名 on 表名
```

# 5. Mybatis 使用 xml 映射文件

######  	![](http://m.qpic.cn/psc?/V13bGCHq2JiKDh/TmEUgtj9EK6.7V8ajmQrECJs1CG47RRxgN.LqjG2ptuxM*osF1BuUhPOMi7MAmLx.l7FqS4MpI6DxZlRYn934rWsXtsY8LwPPkrOmXHwQHs!/b&bo=iwN1AQAAAAADJ*4!&rf=viewer_4)

# 6. 登录认证

##### 	1.  Cookie

​		优点: http协议中支持的技术

​		缺点: 	移动端无法使用Cookie; 不安全,	 用户可以直接禁用Cookie; 	Cookie不能跨域

##### 	2.  session	

​		优点: 存储在服务器, 安全

​		缺点: 服务器集群环境下无法直接使用session; 	Cookie的缺点

##### 	3.  令牌技术		

​		优点: 支持pc端、移动端;	解决集群环境下的认证问题;	减轻服务器的存储压力 

​		缺点: 需要自己实现

# 7. Filter 登录校验

##### 		1. 定义Filter: 定义一个类, 实现Filter接口(javax.servlet), 并重写其所有方法

##### 		2. 配置Filter: Filter类上加上@WebFilter(urlPatterns = "/*") 注解, 配置拦截资源路径,  在启动类上加上@ServletComponentScan注解 开启Servlet组件支持

# 8. Interceptor 登录校验

##### 		1. 定义拦截器, 实现HandlerInterceptor接口, 并重写所有方法(ctrl+o), 交给ioc容器管理@Component

​		

```java
package com.itmwm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器类
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
  @Override // 目标资源方法运行前运行 返回 ture 放行 false: 拦截
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	System.out.println("preHandle...");
	return HandlerInterceptor.super.preHandle(request, response, handler);
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
```

##### 		2. 注册拦截器, 实现WebMvcConfigurer接口,并重写 addInterceptors 方法,添加@Configuration注解

```java
package com.itmwm.config;

import com.itmwm.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private LoginCheckInterceptor loginCheckInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**") // 拦截所有资源 /*: 一级路径 /**: 任意路径
			.excludePathPatterns("/login"); // 不需要拦截哪些资源路径
  }
}
```

# 9. Filter 与 Interceptor

##### 		1. 接口规范不痛: 过滤器需要实现FIlter接口,而拦截器需要实现HandleInterceptor接口

##### 		2. 拦截复位不痛: 过滤器Filter会拦截web服务器所有资源, 而Interceptor只会拦截Spring环境中的资源

# 10. AOP 面向切面编程

##### 		1. 快速入门

```xml
pom.xml 引入依赖
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-aop</artifactId>
   <version>3.3.3</version>
</dependency>
```

```java
package com.itmwm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect  // 表示当前类为aop类
public class TimeAspect {

  /*
   * @Around 当前共性方法作用于哪里
   * execution(* com.itmwm.service.*.*(..)) 加到哪些方法上
   * 第一个 * 表示返回值是任意的, com.itmwm下的service下的所有接口或者类中的所有方法都会运行这部分公共代码
   */
  @Around("execution(* com.itmwm.service.*.*(..))") // 接入点表达式
  public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
	// 1. 记录开始时间
	long begin = System.currentTimeMillis();

	// 2. 运行原始方法
	Object result = joinPoint.proceed();

	// 3. 获取方法运行结束时间, 计算执行时间
	long end = System.currentTimeMillis();
	log.info(joinPoint.getSignature() + "方法执行耗时: {}", end - begin);
	return result;
  }
}
```

##### 		2. 通知类型

			1. @Around: 环绕通知,此注解标注的通知方法在目标方法前、后都被执行
			1. @Before: 前置通知, 此注解标注的通知方法在目标方法前被执行
			1. @After: 后置通知, 此注解标注的通知方法会在目标方法后被执行, 无论是否有异常都会执行
			1. @AfterReturning:  返回后通知,此注解标注的通知方法在目标方法后被执行,有异常不执行
			1. @AfterThrowimg: 异常后通知,此注解标注的通知方法在目标方法发生异常后被执行

##### 		3. @PointCut 

该注解的作用是将公共的切入点表达式抽取处理, 需要用到的时候引用该切入点表达式即可

```java
@PointCut("execution(* com.itmwm.service.*.*(..))")
public void pt(){}

 @Around("pt")
  public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
```

##### 		4. 多个切面的切入点匹配同一个目标方法的执行顺序默认是按照切面类的类名字母排序A-Z,自定义排序@Order(1-N)越小越先执行,先进后出

##### 		5. 切入点表达式

1. execution: execution(访问修饰符? 返回值 包名.类名.?方法名(方法参数) throws 异常)

   *: 通配符; ..: 任意类型任意参数

2. @annotation("com.itmwm.ann.MyLog"); 
   com.itmwm.ann.MyLog: 自定义注解的全类名; 然后在目标方法加上@MyLog注解即可对应执行

# 11. SpringBoot 原理

#### 	起步依赖(Maven的依赖传递), 导入一个依赖,会把相关依赖也导入

#### 	自动配置原理 

​	核心: @SpringBootApplication注解上, @SpringBootApplication包含了三个注解:

1. SpringBootConfiguration:
2. ComponentScan
3. EnableAutoConfiguration(自动配置的核心), 底层封装了@Import注解,@Import指定了一个类AutoConfigurationImportSelector.class实现类,在实现类中需要需要实现ImportSelector接口中的一个方法String[] selectImports(...), 该方法的返回值是需要将哪些类交给Spring的IOC容器管理,此时会去读取两个文件spring.factories/AutoConfiguration.imports,在AotuConfiguration文件中就会去配置大量的自动配置的类;
   配置类中所有的bean并不会全部加载到IOC容器中,而是会根据@Conditional注解进行条件装配,条件成立才会交给Spring的IOC容器管理

# 12. 自定义start

​	需求: 自定义aliyun-oss-spring-boot-start依赖, 完成阿里云OSS操作工具栏AliyunOSSUtils的自动配置

​	目标: 引入起步依赖后,想要使用阿里云OSS,注入AliyunOSSUtils直接使用就可

##### 	步骤: 

1. 创建 aliyun-oss-spring-boot-starter maven模块
2. 创建 aliyun-oss-spring-boot-autoconfigure maven模块,在stater模块中引入该模块
