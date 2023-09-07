package com.example.newslider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newslider.databinding.ItemViewBinding

class TitleAdapter(val titles: List<NewItem>) : RecyclerView.Adapter<TitleAdapter.TitleViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(data: NewItem, position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        val title = titles[position]
        holder.bind(title)

        // 아이템 클릭 리스너 설정
        holder.itemView.setOnClickListener {
            listener?.onItemClick(title, position)
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class TitleViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title: NewItem) {
            with(binding) {
                titleImg.setImageResource(title.titleImage)
                titletext.text=title.title
                contact.text=title.article
            }
        }
    }
}
