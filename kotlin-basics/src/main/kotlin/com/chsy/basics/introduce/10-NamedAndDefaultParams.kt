package com.chsy.basics.introduce

/**
 * 默认参数和具名参数
 */

fun getArea(long: Float, wide: Float): Float {
    return long * wide
}

fun getPerimeter(PI: Float = Pi, radius: Float): Float {
    return 2 * PI * radius
}

fun getPerimeter2(PI: Float = Pi, diameter: Float): Float {
    return PI * diameter
}

val Pi = 3.14159f

fun main() {
    var area = getArea(3f, 4f)
    println("长方形面积：$area")

    getPerimeter(Pi, 3f)
    getPerimeter(radius = 3f)

    getPerimeter2(Pi, 6f)
    getPerimeter2(diameter = 6f)
}