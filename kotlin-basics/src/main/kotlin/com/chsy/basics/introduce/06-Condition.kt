package com.chsy.basics.introduce

fun main() {
    println("80分${checkGrade(80)}")
    println("40分${checkGrade(40)}")
    getComment(checkGrade(80))
    getComment(checkGrade(50))
}

fun checkGrade(grade: Int): String {
    return if (grade > 60) "及格了" else "没及格"
}

fun getComment(remark: String) {
    when(remark) {
        "及格了" -> println("恭喜你，及格了！继续努力哦")
        "没及格" -> println("这次没及格，不要灰心！继续加油！")
    }
}