package com.cua.todolist.view

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.cua.todolist.R
import com.cua.todolist.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.*

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

            menuViewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(mainTabLayout))
            mainTabLayout.addOnTabSelectedListener(object: OnTabSelectedListener{
                override fun onTabReselected(p0: Tab?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onTabUnselected(p0: Tab?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onTabSelected(p0: Tab?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
        }
    }
}
