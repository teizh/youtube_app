package com.example.youtube_app.ui.detail.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtube_app.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

/*    override val viewModel: DetailViewModel by viewModel()
    override fun inflateViewBinding(): ActivityDetailsBinding {
        return ActivityDetailsBinding.inflate(layoutInflater)
    }*/
}