package com.my

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

object Site{
    var url:String = ""
    var name:String = "kotlin"

    override fun toString(): String {
        return "url=${url},name=${name}"
    }
}

fun main(args: Array<String>) {
    var s1 = Site
    var s2 = Site
    s1.url = "www.baidu.com"
    println(s1)
    println(s2)
}

