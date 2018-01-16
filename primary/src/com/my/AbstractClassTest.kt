package com.my

open class Base{
    open fun funf(){}
}

abstract class Derived : Base() {
    override abstract fun funf()
}