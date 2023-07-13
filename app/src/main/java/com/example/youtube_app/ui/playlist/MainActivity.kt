package com.example.youtube_app.ui.playlist

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.youtube_app.core.base.BaseActivity
import com.example.youtube_app.core.network.Resource
import com.example.youtube_app.data.model.PlayListsModel
import com.example.youtube_app.databinding.ActivityMainBinding
import com.example.youtube_app.ui.detail.adapter.DetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, PlaylistViewModel>() {

    private var adapter = PlaylistAdapter(this::onClick)
    //  private lateinit var connectionInternet: ConnectionInternet

    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun setupLiveData() {
        super.setupLiveData()
        viewModel.playlists().observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 ->
                        adapter.setList(it1.items)
                    }
                    binding.recyclerView.adapter = adapter
                    Toast.makeText(this, it.data?.kind ?: "null", Toast.LENGTH_SHORT).show()
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    Log.e("ololo", "setupLiveData: ${it.message}")
                }

                Resource.Status.LOADING -> Toast.makeText(this, "loading", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

/*    override fun checkInternet() {
        super.checkInternet()
        connectionInternet = ConnectionInternet(this)
        connectionInternet.observe(this) { isConnection ->
            if (isConnection) {
                binding.btnTryAgain.setOnClickListener {
                    binding.noInternet.visibility = View.GONE
                    binding.yesInternet.visibility = View.VISIBLE
                }
            } else {
                binding.noInternet.visibility = View.VISIBLE
                binding.yesInternet.visibility = View.GONE
            }
        }
    }*/

    private fun onClick(item: PlayListsModel.Item) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("desc", item.snippet.description)
        intent.putExtra("id", item.id)
        intent.putExtra("count", item.contentDetails.itemCount)
        startActivity(intent)
    }
}