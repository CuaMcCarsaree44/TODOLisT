package com.cua.todolist.repository

import com.cua.todolist.R
import com.cua.todolist.model.Notes
import kotlin.random.Random

class Storage {
    companion object {
        val x = arrayOf(R.color.color1, R.color.color2, R.color.color3,
            R.color.color4, R.color.color5, R.color.color6, R.color.color7,
            R.color.color8, R.color.color9)
        var r:Int = Random.nextInt(0, 8)
        val datas: ArrayList<Notes> = ArrayList()
        var note:Notes = Notes()
        fun execute(){
            for(i in 0..100){
                r = Random.nextInt(0, 8)
                note = Notes()
                note.title = "Data Number $i"
                note.priority = 0
                note.content = "This is Data Number $i's description"
                note.color = x[r]
                datas.add(note)
            }
        }
    }


}