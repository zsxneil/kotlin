package com.my.springboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.my.springboot.model.Greeting
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.web.bind.annotation.*
import java.nio.file.Files
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController{
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name:String) =
            Greeting(counter.incrementAndGet(), "Hello ${name}")

    @GetMapping(value = "/greet")
    fun greet(@RequestParam(value = "name", defaultValue = "default") name: String) : Greeting {
        val greet = Greeting(counter.incrementAndGet(), "this is ${name}")
        println(greet)
        return greet
    }

    @RequestMapping(value = "/greets", method = arrayOf(RequestMethod.GET))
    fun greets(@RequestParam("name") name:String) : Greeting {
        return Greeting(counter.incrementAndGet(), "name is ${name}")
    }

    @RequestMapping(value = "/index", method = arrayOf(RequestMethod.GET,RequestMethod.POST))
    fun index():Map<String,Any>{
        val resultMap = HashMap<String,Any>()
        resultMap["status"] = true
        resultMap["msg"] = "success"
        resultMap.put("greeting", Greeting(counter.incrementAndGet(), "this is greet"))
        return resultMap
    }

    @RequestMapping(value = "/show", method = arrayOf(RequestMethod.POST), consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun test(requestEntity: RequestEntity<String>): Greeting {
        val body = requestEntity.body
        val mapper = ObjectMapper()
        //mapper.readValue(body, Greetin.javaClass)
        println("ddd" + body)



        return Greeting(counter.incrementAndGet(), "name is")
    }
}