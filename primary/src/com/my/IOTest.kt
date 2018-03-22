package com.my

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import java.io.File
import java.net.URL

fun main(args: Array<String>) {
    //readFile()
    //writeFile()
    //traverseFileTree()
    readFromNet()
}

fun readFromNet() {
    /*val baidu = URL("https://www.baidu.com")
    val content = baidu.readText()
    println(content)*/

    try {

        //获取必应首页图片并保存
        //获取XML格式图片信息
        val url:String = "https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=20"
        println(url)
        val bing = URL(url)
        val texts = bing.readText()
        //获取文件地址和文件名
        var json = JSONObject.parseObject(texts)
        var imagesArray = json.getJSONArray("images")
        for (i in 0 until imagesArray.size) {
            var imageInfo:JSONObject = imagesArray.getJSONObject(i)
            var imageUrl = "http://www.bing.com" + imageInfo.getString("url")
            var fileName = imageUrl.substring(imageUrl.lastIndexOf('/'))
            //写入文件
            val output = File("F:\\kotlin\\bing", fileName)
            println(imageUrl)
            val image = URL(imageUrl)
            output.writeBytes(image.readBytes())
        }

    } catch (e:Exception) {
        e.printStackTrace()
    }

}

fun traverseFileTree() {
    val file = File("C:/Windows")
    val fileTree:FileTreeWalk = file.walk()
    fileTree.maxDepth(1)
            .filter { it.isFile }
            .filter { it.extension == "exe" }
            .forEach (::println)
}

fun readFile(){
    val file = File("F:/server-scheme.json")
    val content = file.readText()
    println(content)

    //大写前三行
    file.readLines().take(3).forEach({
        println(it.toUpperCase())
    })

    //直接处理每一行
    file.forEachLine(action = {
        println(it.toUpperCase())
    })

    //读取为bytes
    val bytes:ByteArray = file.readBytes()
    println(String(bytes))

}

fun writeFile(){
    val file = File("F:/kotlintest.txt")
    file.writeText("哈哈哈哈")
    println(file.readText())

    file.writeBytes(byteArrayOf(12, 56, 83, 57))
    println(file.readText())

    //以追加方式
    file.appendText("lalallala")
    println(file.readText())

}