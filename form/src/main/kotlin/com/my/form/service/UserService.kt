package com.my.form.service

interface UserService{
    /**
     * 获取用户总量
     */
    fun allUsers() : Int?

    /**
     * 新增一个用户
     */
    fun create(name:String, address:String?)


    /**
     * 根据姓名删除一个用户
     */
    fun deleteByName(name:String)

    /**
     * 删除所有用户
     */
    fun deleteAllUsers()
}