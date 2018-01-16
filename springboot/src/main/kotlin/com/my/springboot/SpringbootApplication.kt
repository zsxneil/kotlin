package com.my.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringbootApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringbootApplication::class.java, *args)
}
