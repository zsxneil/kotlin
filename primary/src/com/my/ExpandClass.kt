package com.my

fun main(args: Array<String>) {
    var user = User("name")
    user.print("content")
}

class User(name: String)

fun User.print(content: String) {
    println(content)
}