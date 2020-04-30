package com.chsy.kotlindemo.config.result

/**
 * @Description 响应体
 * @Creat At 2020-04-29
 */
class ResponseBody(
    var success: Boolean,
    var code: String,
    var msg: String,
    var data: Any? = null) {
}