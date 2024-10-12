package com.example.demo.Real_Stagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.demo.R

class MainActivity3 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    // Danh sách các hình ảnh sử dụng tài nguyên
    private val imageResIds = listOf(
        R.drawable.meme_1,
        R.drawable.meme_2,
        R.drawable.meme_3,
        R.drawable.meme_4,
        R.drawable.meme_5,
        R.drawable.meme_6,
        R.drawable.meme_8,
        R.drawable.meme_9,
        R.drawable.meme_10,
        R.drawable.meme_11,
        R.drawable.meme_12,
        R.drawable.meme_13,
        R.drawable.meme_14,
        R.drawable.meme_15,
        R.drawable.meme_16,
        R.drawable.meme_17,
        R.drawable.meme_18,
        R.drawable.meme_19,
        R.drawable.meme_20,
        R.drawable.meme_21,
        R.drawable.meme_22,
        R.drawable.meme_23,
        R.drawable.meme_24,
        R.drawable.meme_25,
        R.drawable.meme_26,
        R.drawable.meme_27,
        R.drawable.meme_28
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        recyclerView = findViewById(R.id.staggeredRecyclerView)

        imageAdapter = ImageAdapter(imageResIds)
        recyclerView.adapter = imageAdapter

        // Thiết lập StaggeredGridLayoutManager
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
