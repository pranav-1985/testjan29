package com.example.testjan29.recyclerView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testjan29.R

class RecycleViewHolder(itemView: View, mClickListener: RecyclerViewAdapter.ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {
    var textViewTitle: TextView = itemView.findViewById<TextView>(R.id.news_title_view)
    var textViewDescription: TextView = itemView.findViewById<TextView>(R.id.news_description_view)
    var textViewSource: TextView = itemView.findViewById(R.id.news_source_view)

    init {
        itemView.setOnClickListener { view ->
            mClickListener.onItemClick(view, adapterPosition)
        }
    }
}
