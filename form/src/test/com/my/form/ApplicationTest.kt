package com.my.form

import com.my.form.service.UserService
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTest {

    var log = LoggerFactory.getLogger(ApplicationTest::class.java)

    @Autowired
    lateinit var userService:UserService

    @Test
    fun jdbcTest(){
        val username = "NeilKotlin"
        val address = "深圳市"

        userService.create("$username a", "$address 1")
        userService.create("$username b", "$address 2")
        userService.create("$username c", "$address 3")
        userService.create("$username d", "$address 4")
        userService.create("$username e", "$address 5")

        log.info("总共用户 ${userService.allUsers()}")

        // 删除两个用户
        userService.deleteByName("$username a")
        userService.deleteByName("$username b")

        log.info("总共用户 ${userService.allUsers()}")


    }


}