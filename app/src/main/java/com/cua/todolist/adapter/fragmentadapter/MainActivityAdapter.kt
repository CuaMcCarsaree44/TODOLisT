package com.cua.todolist.adapter.fragmentadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cua.todolist.view.fragments.ReminderFragment
import com.cua.todolist.view.fragments.SettingFragment
import com.cua.todolist.view.fragments.TodoFragment

class MainActivityAdapter constructor(fm: FragmentManager, numberoftabs:Int) : FragmentStatePagerAdapter(fm){
    private val count:Int = numberoftabs
    private lateinit var tab:Fragment

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> tab = TodoFragment()
            1 -> tab = ReminderFragment()
            2 -> tab = SettingFragment()
        }

        return tab
    }

    override fun getCount(): Int {
        return count
    }

}