package com.cua.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName="todolist")
data class Notes (
    @PrimaryKey @ColumnInfo(name = "id") var id:String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "title") var title:String = "",
    @ColumnInfo(name = "content") var content:String = "",
    @ColumnInfo(name = "created_at") var created_at:String = System.currentTimeMillis().toString(),
    @ColumnInfo(name = "priority") var priority:Int = 0,
    @ColumnInfo(name = "background_color") var color:Int = 0
)