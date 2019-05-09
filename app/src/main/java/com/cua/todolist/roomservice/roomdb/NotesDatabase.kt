package com.cua.todolist.roomservice.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cua.todolist.model.Notes
import com.cua.todolist.roomservice.dao.NotesDao

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {
    abstract fun notesdao():NotesDao

    companion object{
        @Volatile
        private var instance:NotesDatabase? = null

        fun getInstance(context: Context):NotesDatabase?{
            if(instance != null){
                return instance as NotesDatabase
            }

            synchronized(this){
                val new_instance = Room.databaseBuilder(context, NotesDatabase::class.java,
                    "notes_db").build()

                instance = new_instance
                return instance
            }
        }
    }
}