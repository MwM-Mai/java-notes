package com.itmwm.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 添加原注解(什么时候生效)
@Target(ElementType.METHOD) // 当前注解作用与哪些地方
public @interface Log {
}
