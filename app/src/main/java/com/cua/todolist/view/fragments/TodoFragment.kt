package com.cua.todolist.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.cua.todolist.R
import com.cua.todolist.adapter.recyclerviewadapter.TodoAdapter
import com.cua.todolist.databinding.FragmentTodoBinding
import com.cua.todolist.repository.Storage
import com.cua.todolist.view.TextEditorActivity

class TodoFragment : Fragment(), View.OnClickListener{
    private lateinit var binding:FragmentTodoBinding
    private lateinit var floats:Animation

    private lateinit var adapter:TodoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       initialBinding(inflater)
       return binding.root
    }

    private fun initialBinding(inflater: LayoutInflater){
        adapter = TodoAdapter(Storage.datas, activity!!)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, null, false)
        binding.apply{
            Log.d("Tagged", "Current Database's Size is ${Storage.datas.size}")
            if(Storage.datas.size == 0){
                floats = AnimationUtils.loadAnimation(context, R.anim.floats)
                todorview.visibility = View.INVISIBLE
                todoerrorlabel.visibility = View.VISIBLE
                arrowanim.visibility = View.VISIBLE
                arrowanim.animation = floats
            }else{
                todoerrorlabel.visibility = View.INVISIBLE
                arrowanim.visibility = View.INVISIBLE
            }
            todorview.adapter = adapter
            todorview.layoutManager = LinearLayoutManager(activity)
            fabHome.setOnClickListener(this@TodoFragment)
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.fabHome -> {
                val intent = Intent(activity, TextEditorActivity::class.java)
                startActivity(intent)
            }
        }
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
