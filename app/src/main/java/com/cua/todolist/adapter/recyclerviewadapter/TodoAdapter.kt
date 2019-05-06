package com.cua.todolist.adapter.recyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cua.todolist.databinding.NotesListBinding
import com.cua.todolist.model.Notes
import com.cua.todolist.viewmodel.fragmentvm.TodoViewModel

class TodoAdapter constructor(x:ArrayList<Notes>) : RecyclerView.Adapter<TodoAdapter.Handler>() {
    private var lists:ArrayList<Notes> = x

    class Handler(private val itemBinding:NotesListBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(note:Notes){
            itemBinding.dataclass = note
            itemBinding.viewmodel = TodoViewModel()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Handler {
        val inflater = LayoutInflater.from(parent.context)
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