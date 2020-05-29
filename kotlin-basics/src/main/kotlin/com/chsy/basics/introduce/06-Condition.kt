package com.chsy.basics.introduce

fun main() {
    println("80分${checkGrade(80)}")
    println("40分${checkGrade(40)}")
}

fun checkGrade(grade: Int): String {
    return if (grade > 60) "及格了" else "没及格"
}