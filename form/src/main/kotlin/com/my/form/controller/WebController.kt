package com.my.form.controller

import com.my.form.model.UserForm
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import javax.validation.Valid

@Controller
class WebController : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        registry!!.addViewController("/results").setViewName("results")
    }

    @GetMapping("/user")
    fun index(userForm: UserForm):String {
        return "userForm"
    }

    @PostMapping("/user")
    fun checkPersonInfo(@Valid userForm: UserForm, errors: Errors) : String {

        var result:String = when {
                errors.hasErrors() -> "userForm"
            else -> {
                "redirect:/results"
            }
        }

        return result;
    }
}
