package com.chsy.basics.introduce

fun main() {
    var sum = add(7, 9)
    println(sum)
    println("${add(7, 9)}")
    println("${subtract(16, 8)}")

    printName("张三")

    var i = {x: Int, y: Int -> x * y}
    println(i(3, 5))
    var j:(Int, Int) -> Int = {x, y -> x * y}
    println(j(3, 5))
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int = a - b

fun printName(name: String): Unit {
    println("name is $name")
}