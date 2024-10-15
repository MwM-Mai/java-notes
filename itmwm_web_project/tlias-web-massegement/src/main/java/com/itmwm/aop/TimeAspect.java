package com.itmwm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect  // 表示当前类为aop类
public class TimeAspect {

  /*
   * @Around 当前共性方法作用于哪里
   * execution(* com.itmwm.service.*.*(..)) 加到哪些方法上
   * 第一个 * 表示返回值是任意的, com.itmwm的service下的所有接口或者类中的所有方法都会运行这部分公共代码
   */
  @Around("execution(* com.itmwm.service.*.*(..))") // 接入点表达式
  public Object recordTime(@NotNull ProceedingJoinPoint joinPoint) throws Throwable {
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
