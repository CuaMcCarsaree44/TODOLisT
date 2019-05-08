package com.cua.todolist.view

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TableLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.cua.todolist.R
import com.cua.todolist.adapter.fragmentadapter.MainActivityAdapter
import com.cua.todolist.adapter.recyclerviewadapter.TodoAdapter
import com.cua.todolist.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var push_left:Animation
    private lateinit var adapter:MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        push_left = AnimationUtils.loadAnimation(this, R.anim.push_left)
        setTabLayout()
    }

    private fun setTabLayout(){
        binding.apply {
            mainTabLayout.setTabTextColors(resources.getColor(R.color.tabIgnored) ,
                                            resources.getColor(R.color.tabSelected))

            mainTabLayout.addTab(mainTabLayout.newTab().setText("TODO List"))
            mainTabLayout.addTab(mainTabLayout.newTab().setText("Reminder"))
            mainTabLayout.addTab(mainTabLayout.newTab().setText("Settings"))
            mainTabLayout.animation = push_left

            adapter = MainActivityAdapter(supportFragmentManager, mainTabLayout.tabCount)
            menuViewPager.adapter = adapter

            menuViewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(mainTabLayout))
            mainTabLayout.addOnTabSelectedListener(object: OnTabSelectedListener{
                override fun onTabReselected(p0: Tab?) {
                    menuViewPager.currentItem = p0!!.position
                }

                override fun onTabUnselected(p0: Tab?) {}

                override fun onTabSelected(p0: Tab?) {
                    menuViewPager.currentItem = p0!!.position
                }

            })
        }
    }
}
