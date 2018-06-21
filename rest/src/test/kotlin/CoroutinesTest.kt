package hello;

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>)= runBlocking {
    val current = System.currentTimeMillis()
    val jobs = List(1_000_000) {
        launch(CommonPool) {
            delay(10L)
            println(it)
        }
    }
    jobs.forEach {
        it.join()
    }
    println("总耗时：" + (System.currentTimeMillis() - current) / 1000)

}