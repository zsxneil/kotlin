import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * 协程举例
 */
fun main(args: Array<String>) = runBlocking {// 开启主协程
    val job = launch(CommonPool) {// 在公共线程池中创建一个协程
        doWorld()
    }
    println("Hello") // 主协程在子协程延迟时继续执行
    job.join();

}

//suspend修饰一个协程方法
suspend fun doWorld() {
    delay(1000L)
    println("World")
}