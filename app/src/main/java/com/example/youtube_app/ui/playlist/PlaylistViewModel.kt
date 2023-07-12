package com.example.youtube_app.ui.playlist

import androidx.lifecycle.LiveData
import com.example.youtube_app.core.base.BaseViewModel
import com.example.youtube_app.core.network.Resource
import com.example.youtube_app.data.model.PlayListsModel
import com.example.youtube_app.repository.Repository

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    fun playlists(): LiveData<Resource<PlayListsModel>> {
        return repository.getPlayLists()
    }
}