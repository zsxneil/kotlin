package com.my.form.model

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.validation.constraints.Min

data class UserForm(@get:NotNull(message = "{name.required}") @get:Size(max = 5, min = 2, message = "{name.size}") var name:String? = "", @get:Min(18) var age:Int? = 0)