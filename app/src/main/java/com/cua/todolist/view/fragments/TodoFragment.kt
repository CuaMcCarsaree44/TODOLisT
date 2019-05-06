package com.cua.todolist.view.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.cua.todolist.R
import com.cua.todolist.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {
    private lateinit var binding:FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       initialBinding(inflater)
       return binding.root
    }

    private fun initialBinding(inflater: LayoutInflater){
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, null, false)
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
