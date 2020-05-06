package com.chsy.fct.controller

import com.chsy.fct.config.Authentication
import com.chsy.kotlindemo.config.result.LogicMsg
import com.chsy.kotlindemo.config.result.RestResult
import com.chsy.kotlindemo.config.result.RestUtil
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("demo")
class DemoController {

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @Authentication(true)
    @GetMapping("info")
    fun getUserInfo(): RestResult {
        log.info("------info api in------")
        return RestUtil.success("成功获取demo信息")
    }

    @GetMapping("log")
    fun getLog(): RestResult {
        var tmp: Boolean = true
        if (tmp) {
            log.info("-----log api in----")
            return RestUtil.success("成功获取demo日志")
        }
        return RestUtil.err(LogicMsg.SYS_ERR)
    }
}