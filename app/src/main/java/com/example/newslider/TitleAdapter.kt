package com.example.newslider

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newslider.databinding.ItemViewBinding

class TitleAdapter(private val context: Context, val titles:List<NewItem>): RecyclerView.Adapter<TitleAdapter.TitleViewHolder>() {
    private val titleList:MutableList<NewItem> = titles.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleAdapter.TitleViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TitleAdapter.TitleViewHolder, position: Int) {
        val titles = titles[position]
        holder.bind(titles)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    inner class TitleViewHolder(private val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(titles: NewItem) {
            with(binding){
                titleImg.setImageResource(titles.titleImage)
                title.text = titles.title
                contact.text = titles.article

            }
        }

    }
}