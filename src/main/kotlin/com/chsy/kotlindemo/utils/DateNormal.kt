package com.chsy.kotlindemo.utils

import java.text.SimpleDateFormat

/**
 * 时间操作库
 */
class DateNormal {

    private val pa = "yyyy-MM-dd HH:mm:ss"

    fun nowTime(): Int {
        //13位转10位
        var nt = System.currentTimeMillis()
        nt = nt / 1000
        return nt.toInt()
    }

    //生成当前时间字符串
    fun nowDateString(pattern: String?): String? {
        var pattern = pattern
        val nt = System.currentTimeMillis()
        if (null == pattern) {
            pattern = pa
        }
        val format = SimpleDateFormat(pattern) //设置格式
        return format.format(nt)
    }

    //时间戳转时间字符串
    fun stampToStr(time: Int, pattern: String?): String? { //        long nt = System.currentTimeMillis();
        var pattern = pattern
        val nt = time.toLong() * 1000
        if (null == pattern) {
            pattern = pa
        }
        val format = SimpleDateFormat(pattern) //设置格式
        return format.format(nt)
    }


    //时间字符串转为时间戳
    fun strToStamp(str: String?): Int {
        return try {
            val simpleDateFormat = SimpleDateFormat(pa)
            val date = simpleDateFormat.parse(str)
            val ts = date.time
            (ts / 1000).toInt()
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }

    //时间字符串转为时间戳
    fun strToStamp(str: String?, pattern: String?): Int {
        return try {
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.parse(str)
            val ts = date.time
            (ts / 1000).toInt()
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }
}