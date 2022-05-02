package com.example.notemaking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val listener: INotesRVAdapter) : RecyclerView.Adapter<ViewHolder>() {
    private val allNotes = ArrayList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)

        val viewHolder = ViewHolder(view)

        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currItem = allNotes[position]

        holder.titleView.text = currItem.toString()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.text)
    val deleteButton : Button = itemView.findViewById(R.id.deleteButton)
}

interface INotesRVAdapter {
    fun onItemClicked(notes: Notes)
}