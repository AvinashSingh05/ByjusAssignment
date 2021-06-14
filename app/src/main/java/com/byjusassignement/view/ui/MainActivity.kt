package com.byjusassignement.view.ui

import android.os.Bundle
import com.byjusassignement.R
import com.byjusassignement.databinding.ActivityMainBinding
import com.byjusassignement.view.adapter.NewsAdapter
import com.skydoves.bindables.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@MainActivity
            viewModel = getViewModel<MainActivityViewModel>()
            adapter = NewsAdapter()
        }.root
    }

}