package com.chsy.fct.mapper

import com.chsy.fct.entity.User
import org.apache.ibatis.annotations.Select

interface UserMapper {
    fun deleteByPrimaryKey(id: Int): Int
    fun insert(record: User?): Int
    fun insertSelective(record: User?): Int

    @Select("SELECT * FROM user WHERE id = #{id}")
    fun selectByPrimaryKey(id: Int): User?
    fun updateByPrimaryKeySelective(record: User?): Int
    fun updateByPrimaryKey(record: User?): Int
}