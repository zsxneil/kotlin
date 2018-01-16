package com.my

class Person{
    var lastName:String = "zhang"
    get() = field.toUpperCase()
    set

    var no : Int = 100
    get() = field
    set(value) {
        if (value > 100) {
            field = value
        } else {
            field = -1
        }
    }
}

fun main(args: Array<String>) {
    var person :Person = Person();
    person.lastName = "wang"
    println("lastName:${person.lastName}")

    person.no = 9;
    println(person.no)

    person.no = 101
    println("no:${person.no}")
}