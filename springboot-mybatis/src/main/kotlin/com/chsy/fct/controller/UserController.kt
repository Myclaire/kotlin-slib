package com.chsy.fct.controller

import com.chsy.fct.service.UserService
import com.chsy.kotlindemo.config.result.ResponseBody
import com.chsy.kotlindemo.config.result.RestResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController {

//    @Autowired
//    private lateinit var userService: UserService
//
//    @RequestMapping("info")
//    fun getUserInfo(@RequestParam("user_id") id: Int): ResponseBody {
//        return RestResult().success(userService.getUserInfo(id))
//    }

}