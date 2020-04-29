package com.chsy.kotlindemo.entity.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class AuthorDto {

    @JsonProperty("user_id")
    @Max(value = 20)
    var id: Long = 0L

    @JsonProperty("real_name")
    @Size(max = 32)
    @NotNull
    var realName: String? = null

    @JsonProperty("nick_name")
    @Size(max = 32)
    var nickName: String? = null

    override fun toString(): String {
        return "id:[$id] real_name:[$realName] nickName:[$nickName]"
    }
}