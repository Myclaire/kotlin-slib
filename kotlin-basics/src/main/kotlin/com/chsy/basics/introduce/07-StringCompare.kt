package com.chsy.basics.introduce

fun main() {
    var str1 = "张三"
    var str2 = "张二"

    //等同java中.equals()方法
    println(str1 == str2)
    println(str1.equals(str2))

    var str3 = "hello"
    var str4 = "HELLO"

    println("忽略大小写比较：" + str3.equals(str4, true))
    println("不忽略大小写比较：" + str3.equals(str4, false))
}