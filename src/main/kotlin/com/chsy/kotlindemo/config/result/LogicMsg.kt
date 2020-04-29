package com.chsy.kotlindemo.config.result

/**
 * @Description 异常枚举
 * @Author chenglong
 * @Creat At 2020-04-29
 */
enum class LogicMsg(private val code: String, private val msg: String) {
    /**
     * 业务异常
     */
    NOUSER("1001", "没有用户!"),
    SYS_ERR("1002", "调用api出错!"), NOPROJECT("2001", "没有找到项目，请稍后再试"), NOPROJECTROLE(
        "2002",
        "没有权限,请联系所有者"
    );

    fun code(): String {
        return code
    }

    fun msg(): String {
        return msg
    }

}