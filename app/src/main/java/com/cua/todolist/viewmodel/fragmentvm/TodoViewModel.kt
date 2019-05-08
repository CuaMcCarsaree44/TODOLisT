package com.cua.todolist.viewmodel.fragmentvm

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import java.sql.Timestamp

class TodoViewModel : ViewModel() {
    companion object{
        val NO_ADAPTER_ATTACHED:Boolean = true
    }


//TODO Edit Convert Time
    fun convertTime(str:String): String{
        val x = Timestamp(str.toLong())
        var char = ""
        char += x.date.toString()

        when(x.date) {
            1 -> char += "st "
            2 -> char += "nd "
            3 -> char += "rd "
            else -> char += "th "
        }

        when(x.month){
            0 -> char += "January "
            1 -> char += "February "
            2 -> char += "March "
            3-> char += "April "
            4 -> char += "May "
            5 -> char += "June "
            6 -> char += "July "
            7 -> char += "August "
            8 -> char += "September "
            9 -> char+= "October "
            10 -> char += "November "
            11 -> char += "December "
        }

        char+= (x.year + 1900).toString() + " "

        if(x.hours < 10){
            char += "0" + x.hours
        }else{
            char += x.hours
        }



        char += ":"

        if(x.minutes < 10){
            char += "0" + x.minutes
        }else{
            char += x.minutes
        }

        char += ":"

        if(x.seconds < 10){
            char += "0" + x.seconds
        }else{
            char += x.seconds
        }

        return char
    }

    fun checkContent(str:String): String{
        //max 67
        var char = ""
        if(str.length > 66){
            for(i in 0..66){
                if(i == 32){
                    char+= "\n"
                }

                char+= str[i]
            }
            char+= "..."
        }else char = str
        return char
    }

    fun checkTitle(str:String): String{
        //max 24
        var char = ""
        if(str.length > 24){
            for(i in 0..23){
                char += str[i]
            }

            char += "..."
        }else char = str
        return char
    }
}