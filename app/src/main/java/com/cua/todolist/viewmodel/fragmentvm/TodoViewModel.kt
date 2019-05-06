package com.cua.todolist.viewmodel.fragmentvm

import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    companion object{
        val NO_ADAPTER_ATTACHED:Boolean = true
    }

    fun checkAdapter(boolean: Boolean): Boolean{
        var x:Boolean = true
        if(boolean == NO_ADAPTER_ATTACHED){
            //If Recycler View is 0
        }else{

        }

        return  x
    }
}