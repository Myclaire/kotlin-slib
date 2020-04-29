package com.chsy.kotlindemo.controller

import com.chsy.kotlindemo.config.result.LogicMsg
import com.chsy.kotlindemo.config.result.ResponseBody
import com.chsy.kotlindemo.config.result.RestResult
import com.chsy.kotlindemo.entity.dto.AuthorDto
import com.chsy.kotlindemo.service.AuthorService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import javax.validation.Valid

@RestController
@RequestMapping("author")
class AuthorController {

    @Autowired
    private lateinit var authorService: AuthorService

    private var result: RestResult = RestResult()

    private var log: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("add")
    fun addAuthor(@Valid @RequestBody authorDto: AuthorDto): ResponseBody {
        try {
            if (authorDto.id == 0L) {
                //增加
                if (authorService.addAuthor(authorDto) != 0) {
                    log.info("数据录入成功，{}", authorDto.toString())
                    return result.success("OK")
                }
                return result.err(LogicMsg.SYS_ERR)
            }
            val author = authorService.getAuthorByid(authorDto.id)
            if (author != null) {
                //修改
                if (authorService.updateAuthor(authorDto) != 0) {
                    log.info("数据修改成功，{}", authorDto.toString())
                    return result.success("OK")
                }
                return result.err(LogicMsg.SYS_ERR)
            }
            return result.err(LogicMsg.SYS_ERR)
        } catch (ex: Exception) {
            log.warn("系统异常，{}", ex.message)
            return result.err(LogicMsg.SYS_ERR)
        }
    }

}