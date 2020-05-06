package com.chsy.fct.service

import com.chsy.fct.entity.User
import com.chsy.fct.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    fun getUserInfo(id: Int): User? {
        return userMapper.selectByPrimaryKey(id)
    }



}