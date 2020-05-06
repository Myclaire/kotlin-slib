package com.chsy.fct.controller

import com.chsy.fct.service.UserService
import com.chsy.kotlindemo.config.result.RestResult
import com.chsy.kotlindemo.config.result.RestUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@EnableCaching
@RestController
@RequestMapping("user")
class UserController {

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("info")
    @Cacheable(value = ["user"])
    fun getUserInfo(@RequestParam("user_id") id: Int): RestResult {
        return RestUtil.success(userService.getUserInfo(id))
    }



}