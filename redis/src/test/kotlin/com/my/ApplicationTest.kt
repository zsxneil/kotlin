package com.my

import com.my.redis.User
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTest {

    val log = LoggerFactory.getLogger(ApplicationTest::class.java)!!

    @Resource
    lateinit var stringRedisTemplate:StringRedisTemplate

    @Resource
    lateinit var redisTemplate:RedisTemplate<String, User>

    @Test
    fun stringTest() {
        //保存字符串
        stringRedisTemplate.opsForValue().set("url", "www.baidu.com")
        log.info("百度的网址: ${stringRedisTemplate.opsForValue().get("url")}")
    }

    @Test
    fun objectTest() {
        val user = User("Neil", 20)
        redisTemplate.opsForValue().set(user.username, user)
        log.info("Neil的年龄：${redisTemplate.opsForValue().get("Neil").age}")
    }

}

