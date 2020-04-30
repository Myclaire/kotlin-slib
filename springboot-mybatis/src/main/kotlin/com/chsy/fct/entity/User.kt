package com.chsy.fct.entity

class User {
    var id: Int? = null
    var no: String? = null
        set(no) {
            field = no?.trim { it <= ' ' }
        }
    var name: String? = null
        set(name) {
            field = name?.trim { it <= ' ' }
        }
    var age: Short? = null
    var createTime: Int? = null
    var updateTime: Int? = null

}