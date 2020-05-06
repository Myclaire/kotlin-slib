package com.chsy.kotlindemo.config.result


/**
 * @Description 统一返回Rest风格的数据结构
 * @Creat At 2020-04-29
 */
object RestUtil {
    /**
     * 请求是否成功
     */
    private var success: Boolean = false
    /**
     * 成功或者失败的code错误码
     */
    private lateinit var code: String
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private lateinit var msg: String
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private var data: Any? = null

    override fun toString(): String {
        return "RestResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg=" + msg +
                ", data=" + data +
                '}'
    }

    fun success(data: Any?): RestResult {
        success = true
        this.code = "0"
        msg = "success"
        this.data = data
        return RestResult(success, code, msg, data)
    }

    fun err(msg: LogicMsg): RestResult {
        this.success = false
        this.code = msg.code()
        this.msg = msg.msg()
        this.data = null
        return RestResult(success, code, this.msg, data)
    }

}