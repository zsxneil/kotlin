package com.my

class Runoob constructor(name : String){

    var url:String = "http://www.runoob.com"
    var country:String = "zh"
    var siteName = name;

    constructor(name: String, country: String) : this(name){
        this.country = country;
        println("次构造函数:${this.country}")
    }


    init {
        println("初始化网络名：${name}")
    }

    fun printTest(){
        println("我是类的函数")
    }

}

fun main(args: Array<String>) {
    val runoob = Runoob("菜鸟教程","en")
    /*println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()*/
}