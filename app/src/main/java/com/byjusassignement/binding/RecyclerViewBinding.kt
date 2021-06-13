package com.byjusassignement.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byjusassignement.model.News
import com.byjusassignement.view.adapter.NewsAdapter
import com.skydoves.whatif.whatIfNotNull

object RecyclerViewBinding {

    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter.apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }
    }

    @JvmStatic
    @BindingAdapter("adapterNewsList")
    fun bindAdapterMovieList(view: RecyclerView, movies: List<News>?) {
        movies.whatIfNotNull {
            (view.adapter as? NewsAdapter)?.getNewsList(it)
        }
    }
}