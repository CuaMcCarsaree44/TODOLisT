package com.cua.todolist.roomservice.dao

import androidx.room.*
import com.cua.todolist.model.Notes
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NotesDao {
    @Insert
    fun insert(note: Notes):Completable

    @Update
    fun update(note: Notes):Completable

    @Delete
    fun delete(note: Notes):Completable

    @Query("SELECT * FROM todolist ORDER BY created_at DESC")
    fun getAllData(): Flowable<List<Notes>>
}