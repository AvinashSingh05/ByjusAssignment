package com.byjusassignement.view.ui

import android.os.Bundle
import android.view.View
import com.byjusassignement.R
import com.byjusassignement.databinding.ActivityNewsDetailBinding
import com.byjusassignement.model.News
import com.skydoves.bindables.BindingActivity
import com.skydoves.bundler.bundleNonNull
import com.skydoves.bundler.intentOf
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationCompat.onTransformationEndContainerApplyParams
import com.skydoves.transformationlayout.TransformationLayout

class NewsDetailActivity : BindingActivity<ActivityNewsDetailBinding>(R.layout.activity_news_detail),
    View.OnClickListener {

    private val intentNews: News by bundleNonNull(NEWS_DETAIL)

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainerApplyParams(this)
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@NewsDetailActivity
            newsdetail = intentNews
            backpress.setOnClickListener(this@NewsDetailActivity)
        }
    }

    companion object {
        private const val NEWS_DETAIL = "news_detail"
        fun startActivityModel(transformationLayout: TransformationLayout, news: News?) {
            transformationLayout.context.intentOf<NewsDetailActivity> {
                putExtra(NEWS_DETAIL to news)
                TransformationCompat.startActivity(transformationLayout, intent)
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backpress ->{
                supportFinishAfterTransition()
            }
        }
    }
}