package com.my

fun main(args: Array<String>) {
    var s =  Student("Runoob", 18, 100, 89)
    s.study()
}

/**用户基类**/
open class PersonClass(name: String){
    /**次级构造函数**/
    constructor(name: String, age: Int) : this(name){
        //初始化
        println("-------基类次级构造函数---------")
    }

    open fun study() {
        println("毕业了")
    }

}

/**子类继承 Person 类**/
class Student : PersonClass {
    constructor(name: String, age: Int, no: Int, score: Int) : super(name, age){
        println("-------继承类次级构造函数---------")
        println("学生姓名：${name}")
        println("学生年龄：${age}")
        println("学生编号：${no}")
        println("学生成绩：${score}")
    }

    /*override fun study() {
        println("继承类毕业了")
    }
*/
}
