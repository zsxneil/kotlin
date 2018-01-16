package com.my

fun main(args: Array<String>) {
    val demo = OuterClass().InnerClass().foo()
    println(demo) //   1
    val demo2 = OuterClass().InnerClass().innerTest()
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性
}

class OuterClass {
    private val bar:Int = 2;
    var v = "成员属性"
    /**嵌套内部类**/
    inner class InnerClass{
        fun foo() = bar
        fun innerTest() {
            var o = this@OuterClass
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }

}