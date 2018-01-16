package com.my

import com.sun.org.apache.xpath.internal.SourceTree

fun main(args: Array<String>) {
//    listTest()
//    mapTest()
    setTest()
}

fun setTest() {
    var set = mutableSetOf<String>("a", "b", "c", "c")
    println(set)
    set.add("d")
    println(set)
}

fun mapTest() {
    var map = mutableMapOf(Pair(1,"a"), Pair(2,"b"))
    println(map)
    println(map.size)
    map = map.plus(Pair(3,"c")).toMutableMap()
    println(map)

    for (key in map.keys) {
        println(key)
    }


    for (value in map.values) {
        println(value)
    }

    for (pair in map) {
        println("${pair.key}:${pair.value}")
    }
}


fun listTest() {

    var list = listOf(1,2,3,4,5,6,7,8,9)
    var mutableList = mutableListOf(1,2,3,4,5,6,7,8,9)

    //总数操作
    println(list.any{it % 2 == 0})
    println(list.all{ it % 2 == 1})
    println(list.count { it % 2 == 1 })

    println(list.fold(0) {total, next -> total + next}) //在给定初始值的基础上，从第一项到最后一项进行累加(累计计算，不一定是加)；
    println(list.foldRight(0 ) {total, next -> total + next})

    list.forEach {
        value -> if (value > 8) println(value)
    }

    list.forEachIndexed { index, i ->
        if (i > 8) {
            println("list${index} is ${i}")
            println("test")
        }

    }

    println(list.max())
    println(list.maxBy { it / 2 })

    println(list.min())
    println(list.minBy { it * 2 })

    println(list.none { it % 2 == 1 })

    println(list.reduce { total, next -> total * next  })

    println(list.sum())
    println(list.sumBy { it - 1 })

    //过滤操作
    println("**********过滤操作***********")
    println(list.drop(5))
    println(list.dropLast(1))
    println(list.dropWhile { it < 9 })
    println(list.dropLastWhile { it < 9 })

    println(list.filter { it % 2 == 1 })
    println(list.filterNot { it % 2 == 1 })
    println(list.filterNotNull())

    println(list.take(2))

    println("***********映射操作****************")
    println(list.flatMap { listOf(it *2) })
    println(list.groupBy { if (it % 2 == 0) "even" else "odd" })

    println("************生产操作************")
    println(list.partition { it % 2 == 1 })
    println(list.zip(listOf(7, 8)))

    println("*************排序操作**************")
    println(list.sorted())
    println(list.reversed())
    println(list.sortedDescending())
}