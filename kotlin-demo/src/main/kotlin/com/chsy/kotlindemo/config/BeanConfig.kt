package com.chsy.kotlindemo.config

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@PropertySource(value = *arrayOf("classpath:application.properties"))
open class BeanConfig {

    @Autowired
    private lateinit var env: Environment

    @Bean
    open fun dataSource(): DataSource {
        val dataSource = DruidDataSource()
        dataSource.driverClassName = env!!.getProperty("source.driverClassName")?.trim() ?: String.toString()
        dataSource.url = env.getProperty("source.url")?.trim() ?: String.toString()
        dataSource.username = env.getProperty("source.username")?.trim() ?: String.toString()
        dataSource.password = env.getProperty("source.password")?.trim() ?: String.toString()
        return dataSource
    }

    @Bean
    open fun jdbcTemplate(): JdbcTemplate {
        val jdbcTemplate = JdbcTemplate()
        jdbcTemplate.dataSource = dataSource()
        return jdbcTemplate
    }
}