package com.byjusassignement.view.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.byjusassignement.base.DispatchViewModel
import com.byjusassignement.model.News
import com.byjusassignement.repository.NewRepository

class MainActivityViewModel constructor(
    var newRepository: NewRepository,
) : DispatchViewModel() {

    val _newListLiveData: MutableLiveData<List<News>> = MutableLiveData()
    var newListLiveData: LiveData<List<News>> = _newListLiveData

    val isNewListLoading: ObservableBoolean = ObservableBoolean(true)

    init {
        newListLiveData = launchOnViewModelScope{
            newRepository.loadNews {
                isNewListLoading.set(false)
            }.asLiveData()
        }
    }
}