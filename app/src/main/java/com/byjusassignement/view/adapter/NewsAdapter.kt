package com.byjusassignement.view.adapter

import android.os.SystemClock
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.byjusassignement.R
import com.byjusassignement.databinding.ItemPosterBinding
import com.byjusassignement.model.News
import com.byjusassignement.view.ui.NewsDetailActivity
import com.skydoves.bindables.binding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsListViewHolder>(){

    private val items: MutableList<News> = arrayListOf()
    private var onClickedAt = 0L

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListViewHolder {
        val binding = parent.binding<ItemPosterBinding>(R.layout.item_poster)
        return NewsListViewHolder(binding).apply {
            binding.root.setOnClickListener {
                val news = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                val currentClickedAt = SystemClock.elapsedRealtime()
                if (currentClickedAt - onClickedAt > binding.transformationLayout.duration) {
                    NewsDetailActivity.startActivityModel(binding.transformationLayout, items[news])
                }
            }
        }
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        with(holder.binding) {
            news = items[position]
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getNewsList(movies: List<News>) {
        val previousItemSize = items.size
        items.addAll(movies)
        notifyItemRangeInserted(previousItemSize, movies.size)
    }

    class NewsListViewHolder(val binding: ItemPosterBinding) : RecyclerView.ViewHolder(binding.root)
}