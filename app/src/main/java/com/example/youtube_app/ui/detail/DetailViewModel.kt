package com.example.youtube_app.ui.detail

import androidx.lifecycle.LiveData
import com.example.youtube_app.core.base.BaseViewModel
import com.example.youtube_app.core.network.Resource
import com.example.youtube_app.data.model.PlayListsModel
import com.example.youtube_app.repository.Repository

class DetailViewModel(private val repository: Repository) : BaseViewModel() {

    fun playlistItems(id: String): LiveData<Resource<PlayListsModel>> {
        return repository.getPlaylistItems(id)
    }
}
