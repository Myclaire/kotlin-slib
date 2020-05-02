package com.chsy.fct.service.schedule

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.stereotype.Component
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException
import java.time.LocalDateTime
import java.util.*

@Component
class CronTask {

    private val random = Random()

    private val log = LoggerFactory.getLogger(CronTask::class.java)

    @Autowired
    var cronService: CronService? = null

    @Value("\${rainbow.host1:10.50.8.246}")
    private val taskHost1: String? = null
    @Value("\${rainbow.host2:10.210.64.10}")
    private val taskHost2: String? = null

    @Value("\${rainbow.threadNum:2}")
    private val threadNum: Int? = null

    @Bean
    fun taskScheduler(): TaskScheduler? {
        val taskScheduler =
            ThreadPoolTaskScheduler()
        taskScheduler.poolSize = threadNum!!
        return taskScheduler
    }

    @Scheduled(fixedRate = 5000)
    fun getCurrentTime() {
        val startTime = (System.currentTimeMillis() / 1000).toInt()
        //设置线程和log相关信息
        MDC.put("LogID", startTime.toString() + random.nextInt(100).toString())
        try { //指定ip调用
            if (taskHost1 == getInet4Address()) {
                log.info("开始执行定时任务:{}", LocalDateTime.now())
                cronService?.getCurrentTime()
                val endTime = (System.currentTimeMillis() / 1000).toInt()
                log.info(
                    "执行时间 : {} s",
                    endTime - startTime
                )
                Thread.sleep(6000)
            }
        } catch (e: Exception) {
            log.warn(e.message)
        }
    }

    @Scheduled(fixedRate = 1000)
    fun getRemark() {
        val startTime = (System.currentTimeMillis() / 1000).toInt()
        //设置线程和log相关信息
        MDC.put("LogID", startTime.toString() + random.nextInt(100).toString())
        try { //指定ip调用
            if (taskHost1 == getInet4Address()) {
//                log.info("开始执行定时任务:{}", LocalDateTime.now())
                cronService?.getRemark()
//                val endTime = (System.currentTimeMillis() / 1000).toInt()
//                log.info(
//                    "执行时间 : {} s",
//                    endTime - startTime
//                )
            }
        } catch (e: Exception) {
            log.warn(e.message)
        }
    }

    private fun getInet4Address(): String? {
        val nis: Enumeration<NetworkInterface>
        var ip: String? = null
        try {
            nis = NetworkInterface.getNetworkInterfaces()
            while (nis.hasMoreElements()) {
                val ni = nis.nextElement()
                val ias = ni.inetAddresses
                while (ias.hasMoreElements()) {
                    val ia = ias.nextElement()
                    //ia instanceof Inet6Address && !ia.equals("")
                    if (ia is Inet4Address && ia.getHostAddress() != "127.0.0.1") {
                        ip = ia.getHostAddress()
                    }
                }
            }
        } catch (e: SocketException) { // TODO Auto-generated catch block
            e.printStackTrace()
        }
        return ip
    }
}