package com.my.form.service.impl

import com.my.form.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class UserServiceImpl:UserService {

    @Autowired
    private val jdbcTemplate:JdbcTemplate? = null

    override fun allUsers(): Int? {
        return jdbcTemplate!!.queryForObject("select count(*) from user" ,Int::class.java)
    }

    override fun create(name: String, address: String?) {
        jdbcTemplate!!.update("insert into user (username, address) values(?, ?)", name ,address)
    }

    override fun deleteByName(name: String) {
        jdbcTemplate!!.update("delete from user where username = ?", name)
    }

    override fun deleteAllUsers() {
        //jdbcTemplate!!.update("delete from user")
    }

}