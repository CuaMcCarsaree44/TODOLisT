package com.cua.todolist.adapter.recyclerviewadapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.cua.todolist.R
import com.cua.todolist.databinding.NotesListBinding
import com.cua.todolist.model.Notes
import com.cua.todolist.view.MainActivity
import com.cua.todolist.viewmodel.fragmentvm.TodoViewModel

class TodoAdapter constructor(x:ArrayList<Notes>, c: FragmentActivity) : RecyclerView.Adapter<TodoAdapter.Handler>() {
    private var lists:ArrayList<Notes> = x
    private var context:FragmentActivity = c
    private var viewModel = ViewModelProviders.of(context).get(TodoViewModel::class.java)
    private val pushleft = AnimationUtils.loadAnimation(context, R.anim.push_left)


    inner class Handler(private val itemBinding:NotesListBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(note:Notes){
            itemBinding.apply {
                itemBinding.dataclass = note
                itemBinding.viewmodel = viewModel
                itemBinding.notesCardView.setCardBackgroundColor(context.resources.getColor(note.color))
                itemBinding.notesCardView.animation = pushleft


                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Handler {
        val inflater = LayoutInflater.from(parent.context)

        Log.d("Tagged", "Current Context is $context.toString()")
        Log.d("Tagged", "Current lists size is $lists.size")
        val binding = NotesListBinding.inflate(inflater, null, false)
        return Handler(binding)
    }

    override fun getItemCount(): Int {


        return lists.size
    }

    override fun onBindViewHolder(holder: Handler, position: Int) {
        val note:Notes = lists[position]
        holder.apply{
            bind(note)
        }
    }

}