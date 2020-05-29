package com.chsy.basics.introduce

fun main() {
    var num1 = 4
    var num2 = 9
    println("$num1 < $num2 : ${num1 < num2}")

    //根号
    var num3 = Math.sqrt(4.0)
    var num4 = Math.sqrt(9.0)
    println("$num3 > $num4 : ${num3 > num4}")

    //次方
    var num5 = Math.pow(2.toDouble(), 10.toDouble())
    var num6 = Math.pow(3.toDouble(), 5.toDouble())
    println("$num5 < $num6 : ${num5 < num6}")

}