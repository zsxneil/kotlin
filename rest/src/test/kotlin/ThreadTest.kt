import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val current = System.currentTimeMillis();
    val threadList = List(1_000_000) {
        thread {
            Thread.sleep(10L)
            println(it)
        }
    }

    threadList.forEach {
        it.start();
        it.join()
    }
    println("总耗时：" + (System.currentTimeMillis() - current) / 1000)
}