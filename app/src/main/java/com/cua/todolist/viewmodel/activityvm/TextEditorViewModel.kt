package com.cua.todolist.viewmodel.activityvm

import androidx.lifecycle.ViewModel
import com.cua.todolist.repository.Onruncache

class TextEditorViewModel : ViewModel(){
    fun stringCount(content:String):String{
        return content.length.toString()
    }

    fun wordsCount(content:String):String{
        var number = 1
        if(content == ""){
            number = 0
        }else {
            for (i in 0 until content.length) {
                try {
                    if(content[i] == ' ' && content[i+1] == ' ') continue
                }catch(e:Exception){
                    if(i == 0)
                        if(content[i] == ' ') number--
                }

                if (content[i] == ' ') number++
            }
        }
        return number.toString()
    }

    fun setTitleDraft(x:String){
        Onruncache.title = x
    }

    fun setContentDraft(x:String){
        Onruncache.content = x
    }

    fun getTitleDraft():String{ return Onruncache.title }
    fun getContentDraft():String{ return Onruncache.content }
}