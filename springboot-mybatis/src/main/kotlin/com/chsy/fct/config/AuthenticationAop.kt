package com.chsy.fct.config

import com.chsy.fct.service.schedule.CronTask
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Component

@Aspect
@Component
class AuthenticationAop {

    private val log = LoggerFactory.getLogger(CronTask::class.java)

    @Autowired
    var cacheManager: CacheManager? = null

    /**
     * 指定切点方法
     * 第一种指定：直接指定controller包下的任意返回任意个参数的公共方法
     * @Pointcut("execution(public * com.chsy.fct.controller.*.*(..))")
     * 第二种指定：通过注解指定
     * @Pointcut(value = "@annotation(com.chsy.fct.config.Authentication)")
     */

    //通过注解指定切点方法，使用注解的方法都会被切入
    @Pointcut(value = "@annotation(com.chsy.fct.config.Authentication)")
    fun pointCut() {
    }

//    //环绕通知同时完成前置和后置通知
//    @Around("pointCut()")
//    fun checkLogin() {
//        log.info("------------check login success----------")
//    }

    @Before("pointCut()")
    fun storeInfo() {
        log.info("-----------store user info------------")
    }

    @AfterReturning("pointCut()")
    fun successExecute() {
        log.info("--------after returning no exception-----------")
    }

    @AfterThrowing("pointCut()")
    fun exceptionExecute() {
        log.info("--------some exception--------")
    }


}