package com.my

fun main(args: Array<String>) {
    //ifReturnTest()
    //ifRangeTest()
    whenTest()
}

/**
 * 相当于switch case
 */
fun whenTest() {
    var x = 7;
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        4,5 -> print("多个相同处理")
        in 6..9 -> print("在6到9的范围内")
        //is String -> print(x.length)
        else ->{
            print(x)
        }

    }
}

fun ifRangeTest() {
    var a = 5;
    var b = 9;
    if (a in 1..8) {
        print(a)
    }
}

fun ifReturnTest() {
    var a = 1
    var b = 2
    var c = if (a>=b) a else b
    println("c 的值为 $c")

}


