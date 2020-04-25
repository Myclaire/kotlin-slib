package com.chsy.kotlindemo.controller

import com.chsy.kotlindemo.entity.dto.AuthorDto
import com.chsy.kotlindemo.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("author")
class AuthorController {

    @Autowired
    private lateinit var authorService: AuthorService

    @PostMapping("add")
    fun addAuthor(@Valid @RequestBody authorDto: AuthorDto): String {
        if (authorService.addAuthor(authorDto) != 0) {
            return "OK!"
        }
        return "Fail!"
    }
}