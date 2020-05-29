package com.chsy.basics.introduce

fun main() {

    println(diaryGenerater("天安门"))
    println(diaryGenerater("大兴安岭"))
}

fun diaryGenerater(space: String): String {
    return """
        今天周末，我们去了${space}游玩，一进门就看见${space}${space.length}个大字
    """
}