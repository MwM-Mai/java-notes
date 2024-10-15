package com.itmwm.aop;

import com.alibaba.fastjson2.JSONObject;
import com.itmwm.mapper.OperateLogMapper;
import com.itmwm.pojo.OperateLog;
import com.itmwm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect // 切面类
public class LogAspect {

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private OperateLogMapper operateLogMapper;

  @Around("@annotation(com.itmwm.anno.Log)")
  public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
	long begin = System.currentTimeMillis();

	// 操作员Id
	String token = request.getHeader("token");
	Claims claims = JwtUtils.parseJWT(token);
	Integer userId = (Integer) claims.get("id");

	// 操作时间
	LocalDateTime now = LocalDateTime.now();

	// 操作类名
	String className = joinPoint.getTarget().getClass().getName();

	// 操作方法名
	String methodName = joinPoint.getSignature().getName();

	// 操作方法的参数
	String methodParams = Arrays.toString(joinPoint.getArgs());

	// 调用原始方法运行
	// 操作方法的返回值
	Object result = joinPoint.proceed();
	long end = System.currentTimeMillis();

	String returnValue = JSONObject.toJSONString(result);

	// 操作耗时
	long duration = end - begin;

	OperateLog operateLog = new OperateLog(null, userId, now, className, methodName, methodParams, returnValue, duration);
	operateLogMapper.insert(operateLog);
	return result;
  }
}
