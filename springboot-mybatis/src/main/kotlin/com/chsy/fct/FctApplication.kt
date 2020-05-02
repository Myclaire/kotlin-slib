package com.chsy.fct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
//@MapperScan("com.chsy.fct.mapper")
//@EnableScheduling
class FctApplication

fun main(args: Array<String>) {
	runApplication<FctApplication>(*args)
}
