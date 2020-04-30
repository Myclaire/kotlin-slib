package com.chsy.fct.mapper

import com.chsy.fct.entity.User

interface UserMapper {
    fun deleteByPrimaryKey(id: Int): Int
    fun insert(record: User?): Int
    fun insertSelective(record: User?): Int
    fun selectByPrimaryKey(id: Int): User?
    fun updateByPrimaryKeySelective(record: User?): Int
    fun updateByPrimaryKey(record: User?): Int
}