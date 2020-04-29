package com.chsy.kotlindemo.service

import com.chsy.kotlindemo.dao.AuthorDao
import com.chsy.kotlindemo.entity.Author
import com.chsy.kotlindemo.entity.dto.AuthorDto
import com.chsy.kotlindemo.utils.DateNormal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class AuthorService {

    @Autowired
    private lateinit var authorDao: AuthorDao

    fun addAuthor(authorDto: AuthorDto): Int {
        val author = Author()
        author.realName = authorDto.realName
        author.nickName = authorDto.nickName
        author.createTime = DateNormal().nowTime()
        return authorDao.addAuthor(author)
    }

    fun getAuthorByid(id: Long): Author {
        return authorDao.selectAuthor(id)
    }

    fun getAllAuthor(): List<Author> {
        return authorDao.selectAll()
    }

    fun updateAuthor(authorDto: AuthorDto): Int {
        var author = Author()
        author.realName = authorDto.realName
        author.nickName = authorDto.nickName
        author.updateTime = DateNormal().nowTime()
        return authorDao.updateAuthor(author)
    }

    fun deleteAuthor(id: Long): Int {
        return authorDao.delAuthor(id)
    }
}