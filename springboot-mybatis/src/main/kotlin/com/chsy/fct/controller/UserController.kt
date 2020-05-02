package com.chsy.fct.controller

import com.chsy.fct.config.Authentication
import com.chsy.fct.service.UserService
import com.chsy.kotlindemo.config.result.ResponseBody
import com.chsy.kotlindemo.config.result.RestResult
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException
import kotlin.math.log

@RestController
@RequestMapping("user")
class UserController {

    private val log = LoggerFactory.getLogger(UserController::class.java)

//    @Autowired
//    private lateinit var userService: UserService
//
//    @RequestMapping("info")
//    fun getUserInfo(@RequestParam("user_id") id: Int): ResponseBody {
//        return RestResult().success(userService.getUserInfo(id))
//    }

    @Authentication(true)
    @GetMapping("info")
    fun getUserInfo(): ResponseBody {
        log.info("------info api in------")
        return RestResult().success("OK")
    }

    @GetMapping("log")
    fun getLog(): String {
        log.info("-----log api in----")
        return "OK"
    }

}