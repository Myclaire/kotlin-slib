package com.chsy.fct.service.schedule

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class CronService {

    val log = LoggerFactory.getLogger(CronTask::class.java)

    private val dateFormat = SimpleDateFormat("HH:mm:ss")

    fun getCurrentTime() {
        log.info("现在时间 , ${dateFormat.format(Date())}")
    }

    fun getRemark() {
        log.info("remark: -----------------------${dateFormat.format(Date())}")
    }
}