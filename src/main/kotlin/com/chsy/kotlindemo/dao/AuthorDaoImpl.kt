package com.chsy.kotlindemo.dao

import com.chsy.kotlindemo.entity.Author
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class AuthorDaoImpl: AuthorDao {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun addAuthor(author: Author): Int {
        return jdbcTemplate.update("insert into t_author(real_name, nick_name, create_time) values(?, ?, ?)",
                author.realName, author.nickName, author.createTime)
    }

    override fun delAuthor(id: Long): Int {
        return jdbcTemplate.update("delete from t_author where id = ?", id)
    }

    override fun selectAuthor(id: Long): Author {
        var list = jdbcTemplate.query<Author>("select real_name, nick_name from t_author where id = ? limit 1",
                arrayOf<Any>(id), BeanPropertyRowMapper(Author::class.java))
        return list.get(0);
    }

    override fun updateAuthor(author: Author): Int {
        return jdbcTemplate.update("update t_author set real_name = ?, nick_name = ?, update_time = ? where id = ?",
                *arrayOf(author.realName, author.nickName, author.updateTime, author.id))
    }

    override fun selectAll(): List<Author> {
        return jdbcTemplate.query("select * from t_author", arrayOf(), BeanPropertyRowMapper(Author::class.java))
    }
}