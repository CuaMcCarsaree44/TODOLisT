package com.cua.todolist.model

import java.util.*

data class Notes (
    var title:String = "",
    var content:String = "",
    var id:String = UUID.randomUUID().toString(),
    var created_at:String = System.currentTimeMillis().toString(),
    var priority:Int = 0,
    var color:Int = 0
)