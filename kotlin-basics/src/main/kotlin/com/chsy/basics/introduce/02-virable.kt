package com.chsy.basics.introduce

fun main() {
    /**
     * data type
     * 1. Byte  -128~127    8块存储单元  8bit
     * 2. Short -32768~32767            16bit
     * 3. Int   -2147483648~2147483647  32bit
     * 4. Long                          64bit
     * 5. Float
     * 6. Double
     * 7. String
     */
    //define data type
    var school: String
    school = "四川大学"
    var name = "张三"
    var age = 18
    var height = 1.70

    //报错，系统推断类型为Int
//    age = 2147483648
    var bb: Byte = 127

    /**
     * val定义常量，只能赋值一次
     * var定义变量，可赋值多次
     */
    var s: String = "Hello"
    s = "world"
    val x: String = "love"

    /**
     * 获取变量取值范围
     */
    val a: Byte = Byte.MAX_VALUE
    val b: Byte = Byte.MIN_VALUE

    println("Byte的最大值为$a")
    println("Byte的最小值为$b")

    /**
     * 二进制值
     */
    val aInt: Int = 0b0011
    println("aInt的值为$aInt")

}