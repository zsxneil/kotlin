package com.my.thymeleaf.handler

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

/**
 * 统一异常处理
 */
@ControllerAdvice
class GlobalExceptionHandler{

    @ExceptionHandler(value = Exception::class)
    @Throws(Exception::class)
    fun defaultErrorHandler(req: HttpServletRequest, e : Exception) : ModelAndView {
        val mv = ModelAndView()
        mv.addObject("exception", e)
        mv.addObject("url", req.requestURL)
        mv.viewName = "error"
        return mv
    }
}