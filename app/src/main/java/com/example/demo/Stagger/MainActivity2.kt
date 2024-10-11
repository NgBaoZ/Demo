package com.example.demo.Stagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.demo.R


class MainActivity2 : AppCompatActivity() {

    private lateinit var mainCharacterRecyclerView: RecyclerView
    private lateinit var supportingCharacterRecyclerView: RecyclerView
    private lateinit var mainCharacterAdapter: CharacterAdapter
    private lateinit var supportingCharacterAdapter: CharacterAdapter

    // Dữ liệu cho nhân vật chính và phụ
    private lateinit var mainCharacterList: MutableList<Character>
    private lateinit var supportingCharacterList: MutableList<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staggered_item)

        // Nhận dữ liệu từ Intent
        val animeTitle = intent.getStringExtra("ANIME_TITLE")

        // Khởi tạo RecyclerView
        mainCharacterRecyclerView = findViewById(R.id.main_character_recyclerview)
        supportingCharacterRecyclerView = findViewById(R.id.supporting_character_recyclerview)

        mainCharacterRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        supportingCharacterRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Khởi tạo danh sách nhân vật
        mainCharacterList = ArrayList()
        supportingCharacterList = ArrayList()

        // Thêm dữ liệu cho nhân vật chính và phụ
        // Bạn có thể sử dụng switch-case hoặc if-else để kiểm tra animeTitle và thêm dữ liệu tương ứng
        when (animeTitle) {
            "Bocchi The Rock" -> {
                mainCharacterList.add(Character("Bocchi", R.drawable.img_7))
                supportingCharacterList.add(Character("Nijika", R.drawable.img_7))
            }
            // Thêm các anime khác ở đây
        }

        // Đặt adapter cho RecyclerView
        mainCharacterAdapter = CharacterAdapter(mainCharacterList)
        supportingCharacterAdapter = CharacterAdapter(supportingCharacterList)

        mainCharacterRecyclerView.adapter = mainCharacterAdapter
        supportingCharacterRecyclerView.adapter = supportingCharacterAdapter
    }
}
