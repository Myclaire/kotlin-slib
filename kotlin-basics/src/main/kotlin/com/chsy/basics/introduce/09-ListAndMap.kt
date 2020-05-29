package com.chsy.basics.introduce

import java.util.*

fun main() {
    var list = listOf("前天", "昨天", "今天", "明天")
    for (day in list) {
        println(day)
    }
    for ((i, v) in list.withIndex()) {
        println("$i $v")
    }

    var map = TreeMap<String, String>()
    map["好"] = "good"
    map["学习"] = "study"
    map["天"] = "day"
    map["向上"] = "up"
    for ((i, e) in map) {
        println("$i $e")
    }
    println(map["天"])

    var map2 = mapOf("id" to "用户id", "name" to "用户姓名")
    println(map2["id"])
    println(map2["nam"])
}