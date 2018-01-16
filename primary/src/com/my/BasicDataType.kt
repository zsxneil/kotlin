package com.my

fun main(args: Array<String>) {
    val oneMillion = 100_0000
    var isTrue:Boolean = true
   // println(oneMillion)
    //equalTest()
    //typeConvertTest()
    //arrayTest()
    //StringTest()
    strTemplate()
}

fun strTemplate() {
    val i = 10;
    val s = "i=$i"
    print(s)
}

fun StringTest() {
    var str:String = "abcdefg"
    for (char in str) {
        print(char)
    }

    var text = """
        1234555
            dfhkdkf
        gh
    """.trimIndent()
    println()
    print(text)
}

fun arrayTest() {
    var a = arrayOf(1,2,3)
    var b = Array(3,{i -> i * i })
    print(a[0])
    println()
    print(b[2])
}

fun equalTest() {
    var a = 10000;
    var b = 10000;
    println(a == b)
    println(a === b)
    //经过了装箱，创建了两个不同的对象
    var boxA : Int? = 1000;
    var anotherBoxA : Int? = 1000;
    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxA == anotherBoxA)
    println(boxA === anotherBoxA)
}

fun typeConvertTest() {
    val b:Byte = 1;
    val i:Int = b.toInt();
}



