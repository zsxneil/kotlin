package com.my.thymeleaf.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController{
    @GetMapping("/")
    fun index(map: ModelMap) :String{
        map.addAttribute("host", "my web")
        // return模板文件的名称，对应src/main/resources/templates/index.html
        //val i = 1/0
        return "index"
    }
}