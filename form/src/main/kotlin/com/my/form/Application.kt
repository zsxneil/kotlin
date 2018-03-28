package com.my.form

import com.my.form.service.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {


    @Bean
    internal fun init(storageService: StorageService) = CommandLineRunner{
        storageService.deleteAll();
        storageService.init();
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }


}