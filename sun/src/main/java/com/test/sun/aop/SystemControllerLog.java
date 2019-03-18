package com.test.sun.aop;

import java.lang.annotation.*;

/**
 *自定义注解 拦截Controller
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface SystemControllerLog {
    String LogAction()  default "";
    String LogContent()  default "";
    int ModuleID()  default 0;
}