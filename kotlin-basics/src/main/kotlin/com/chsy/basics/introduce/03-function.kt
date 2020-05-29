package com.chsy.basics.introduce

fun main() {
    var sum = add(7, 9)
    println(sum)
    println("${add(7, 9)}")

    printName("张三")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun printName(name: String): Unit {
    println("name is $name")
}