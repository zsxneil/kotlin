package com.my.form.controller

import com.my.form.model.Hello
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloController{

    @RequestMapping("/")
    fun index(map: ModelMap): String {
        map.addAttribute("host", "https://github.com/zsxneil")
        map.addAttribute("hello", Hello())
        return "index"
    }

    @PostMapping("/hello")
    fun hello(@ModelAttribute hello:Hello): String{
        return "result"
    }

}