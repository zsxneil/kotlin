package com.my

fun main(args: Array<String>) {
    rangeTest()
}

fun sum(a : Int, b : Int) : Int{

    return a + b;
}

/**
 * vars(1,2,2)
 */
fun vars(vararg v:Int) {
    println("begin")
    for (vt in v){
        print(vt)
    }
}

fun sumlamba() {
    var sumLamba: (Int, Int) -> Int = {x, y -> x+y};
    println(sumLamba(1,2))
}

/**
 * var length = getStringLength("123");
 */
fun getStringLength(obj: Any) : Int? {
    if (obj is String) {
        return obj.length;
    }
    return null;
}

fun rangeTest() {
    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
}