package com.chsy.fct.config

import com.sftccd.nsdruid.NsDruidDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.stereotype.Component

//@Configuration
//@Component
class DataSourceConfig {
    @Value("\${ns.username}")
    private val username: String? = null
    @Value("\${ns.password}")
    private val password: String? = null
    @Value("\${ns.addr}")
    private val nsaddr: String? = null
    @Value("\${ns.db}")
    private val db: String? = null
    @Value("\${ns.xmlPath}")
    private val mapperXmlPath: String? = null//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(10);

    //在同样的DataSource中，首先使用被标注的DataSource
    @get:Primary
    @get:Bean(name = ["dataSource"], destroyMethod = "destroy")
    val dataSource: NsDruidDataSource
        get() {
            val dataSource = NsDruidDataSource(nsaddr, db)
            dataSource.username = username
            dataSource.password = password
            dataSource.initialSize = 5
            dataSource.minIdle = 5
            dataSource.maxActive = 100
            dataSource.maxWait = 600000
            dataSource.timeBetweenEvictionRunsMillis = 60000
            dataSource.minEvictableIdleTimeMillis = 200000
            //        dataSource.setMaxPoolPreparedStatementPerConnectionSize(10);
            dataSource.init()
            return dataSource
        }

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    @Scope("prototype")
    fun globalConfiguration(): org.apache.ibatis.session.Configuration {
        return org.apache.ibatis.session.Configuration()
    }

    @Bean(name = ["sqlSessionFactory"])
    fun getSqlSessionFactory(
        @Qualifier("dataSource") dataSource: NsDruidDataSource?, config: org.apache.ibatis.session.Configuration?
    ): SqlSessionFactory? {
        val bean = SqlSessionFactoryBean()
        bean.setDataSource(dataSource)
        bean.setConfiguration(config)
        return try { //PathMatchingResourcePatternResolver
            bean.setMapperLocations(
                *PathMatchingResourcePatternResolver().getResources(
                    mapperXmlPath!!
                )
            )
            bean.getObject()
        } catch (e: Exception) {
            null
        }
    }
}