package com.chsy.kotlindemo.entity.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Size
import kotlin.math.max

class AuthorDto {
    @JsonProperty("real_name")
    @Size(max = 32)
    var realName: String? = null

    @JsonProperty("nick_name")
    @Size(max = 32)
    var nickName: String? = null
}