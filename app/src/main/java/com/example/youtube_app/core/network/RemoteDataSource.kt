package com.example.youtube_app.core.network


import com.example.youtube_app.core.base.BaseDataSource
import com.example.youtube_app.data.remote.ApiService
import com.example.youtube_app.utils.Constants

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getPlaylists() = getResult {
        apiService.getPlaylists(
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            apiKey = Constants.API_KEY,
            maxResults = 20
        )
    }

    suspend fun getPlaylistItems(id: String) = getResult {
        apiService.getPlaylistItem(
            key = Constants.API_KEY,
            part = Constants.PART,
            playlistId = id,
            maxResults = 100
        )
    }

    suspend fun getVideos(id: String) = getResult {
        apiService.getVideos(
            key = Constants.API_KEY,
            part = Constants.PART,
            id
        )
    }
}