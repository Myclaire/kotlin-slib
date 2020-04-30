package com.chsy.kotlindemo.dao

import com.chsy.kotlindemo.entity.Author

interface AuthorDao {

    fun addAuthor(author: Author): Int

    fun delAuthor(id: Long): Int

    fun selectAuthor(id: Long): Author

    fun updateAuthor(author: Author): Int

    fun selectAll(): List<Author>
}