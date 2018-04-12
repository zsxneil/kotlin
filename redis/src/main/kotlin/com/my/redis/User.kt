package com.my.redis

import java.io.Serializable

data class User(val username:String, val age:Int?) :Serializable{
    override fun toString(): String {
        return "User(username='$username', age=$age)"
    }



}
