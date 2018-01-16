package com.my

data class People(val name: String, val age: Int)

fun main(args: Array<String>) {
    val jack = People("Jack", 12)
    val olderJack = jack.copy(age = 13)

    println(jack)
    println(olderJack)
}