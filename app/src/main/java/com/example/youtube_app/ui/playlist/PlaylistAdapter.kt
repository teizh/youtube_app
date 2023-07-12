package com.example.youtube_app.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtube_app.data.model.PlayListsModel

import com.example.youtube_app.databinding.ItemPlaylistsBinding

class PlaylistAdapter(private val onCLick: (PlayListsModel.Item) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlayListsViewHolder>() {

    private var list = arrayListOf<PlayListsModel.Item>()

    fun setList(lists: List<PlayListsModel.Item>) {
        this.list = lists as ArrayList<PlayListsModel.Item>
        val previousSize = list.size
        list.clear()
        list.addAll(lists)
        val newSize = list.size
        if (previousSize == newSize) notifyItemRangeChanged(0, newSize)
        else notifyItemRangeChanged(0, newSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        return PlayListsViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class PlayListsViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PlayListsModel.Item) {
            binding.ivPlaylist.load(item.snippet.thumbnails.standard.url)
            binding.tvTitle.text = item.snippet.title
            binding.tvVideoSeries.text = "${item.contentDetails.itemCount} video"

            itemView.setOnClickListener {
                onCLick(item)
            }
        }
    }
}