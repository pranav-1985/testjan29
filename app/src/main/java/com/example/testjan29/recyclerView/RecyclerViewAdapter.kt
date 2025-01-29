package com.example.testjan29.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testjan29.R
import com.example.testjan29.RecyclerViewFragment
import com.example.testjan29.api.NewsModel

class RecyclerViewAdapter(mainActivity: RecyclerViewFragment) :
    RecyclerView.Adapter<RecycleViewHolder>() {

    private var mClickListener: ItemClickListener = mainActivity

    private var newsModelList = listOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        Log.e("Adapter viewType", viewType.toString())
        val mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.recyclerview_row, parent, false)
        return RecycleViewHolder(view, mClickListener)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        Log.e("Adapter position", position.toString())

        val newsModel = newsModelList[position]

        holder.textViewTitle.text = newsModel.newsTitle
        holder.textViewDescription.text = newsModel.newsDescription
        holder.textViewSource.text = newsModel.newsSource
    }

    override fun getItemCount(): Int {
        return newsModelList.size
    }

    fun updateData(currencyModel: List<NewsModel>) {
        newsModelList = currencyModel
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}