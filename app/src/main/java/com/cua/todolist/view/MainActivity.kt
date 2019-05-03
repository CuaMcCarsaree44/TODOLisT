package com.cua.todolist.view

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.cua.todolist.R
import com.cua.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply{
            mainTabLayout.addTab(mainTabLayout.newTab().setText("TODO List"))
            mainTabLayout.addTab(mainTabLayout.newTab().setText("Reminder"))
            mainTabLayout.addTab(mainTabLayout.newTab().setText("Exe"))

        }
    }
}
