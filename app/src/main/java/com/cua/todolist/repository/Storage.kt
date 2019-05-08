package com.cua.todolist.repository

import android.util.Log
import com.cua.todolist.R
import com.cua.todolist.model.Notes
import kotlin.random.Random

class Storage {
    companion object {
        val x = arrayOf(R.color.color1, R.color.color2, R.color.color3,
            R.color.color4, R.color.color5, R.color.color6, R.color.color7,
            R.color.color8, R.color.color9, R.color.color0)
        var r:Int = Random.nextInt(0, 9)
        val datas: ArrayList<Notes> = ArrayList()
        var note:Notes = Notes()
    }

    init{
        for(i in 0..100){
            note = Notes()
            note.title = "Data Number $i and ready to fly"
            note.priority = 0
            note.content = "This is Data Number $i's description"
            note.color = x[i%10]

            datas.add(note)
        }

    }


}