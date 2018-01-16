package hello

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    var javaHello = JavaHello()
    javaHello.print()
    return JavaHello.JavaHelloString!!;
}

fun main(args: Array<String>) {
    getHelloStringFromJava()
}
