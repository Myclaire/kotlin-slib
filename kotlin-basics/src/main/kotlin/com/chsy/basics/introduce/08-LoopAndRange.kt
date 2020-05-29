package com.chsy.basics.introduce

fun main() {
    //闭区间
    var nums = 1 .. 100
    var result = 0
    for (num in nums) {
        result += num
    }
    println("1+..+100的结果：${result}")

    //前闭后开
    var nums2 = 1 until 10 // [1,10)
    for (num in nums2) {
        print("${num},")
    }
    println()

    //步长
    var nums3 = 1 .. 20
    for (a in nums3 step 3) {
        print("${a},")
    }
    println()

    //倒序
    var nums4 = nums2.reversed()
    println(nums4)

    var nowDays = 12
    var nums5 = nowDays downTo 1 step 2
    nums5.forEach {
        print("${it},")
    }
    println("总数为${nums5.count()}")
}