package com.example.demo.Not_Stagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.example.demo.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var mainCharacterRecyclerView: RecyclerView
    private lateinit var supportingCharacterRecyclerView: RecyclerView
    private lateinit var mainCharacterAdapter: CharacterAdapter
    private lateinit var supportingCharacterAdapter: CharacterAdapter
    private lateinit var animeImageView: ImageView
    private lateinit var animeTitleTextView: TextView

    private lateinit var mainCharacterList: MutableList<Character>
    private lateinit var supportingCharacterList: MutableList<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staggered_item)

        // Nhận dữ liệu từ Intent
        val animeTitle = intent.getStringExtra("ANIME_TITLE")

        // Khởi tạo RecyclerView với LayoutManager
        mainCharacterRecyclerView = findViewById<RecyclerView>(R.id.main_character_recyclerview).apply {
            layoutManager = LinearLayoutManager(this@MainActivity2, LinearLayoutManager.HORIZONTAL, false)
        }

        supportingCharacterRecyclerView = findViewById<RecyclerView>(R.id.supporting_character_recyclerview).apply {
            layoutManager = LinearLayoutManager(this@MainActivity2, LinearLayoutManager.HORIZONTAL, false)
        }

        // Khởi tạo ImageView và TextView để hiển thị hình ảnh và tiêu đề phim
        animeImageView = findViewById(R.id.staggered_image)
        animeTitleTextView = findViewById(R.id.staggered_title)

        // Thêm dữ liệu anime dựa trên animeTitle
        val detail = getAnimeDetail(animeTitle)

        // Cập nhật hình ảnh và tiêu đề phim
        detail?.let {
            animeImageView.setImageResource(it.animeImage)
            animeTitleTextView.text = it.title

            // Cập nhật danh sách nhân vật
            mainCharacterList = it.mainCharacters.toMutableList()
            supportingCharacterList = it.supportingCharacters.toMutableList()

            // Khởi tạo adapter
            mainCharacterAdapter = CharacterAdapter(mainCharacterList)
            supportingCharacterAdapter = CharacterAdapter(supportingCharacterList)

            // Đặt adapter cho RecyclerView
            mainCharacterRecyclerView.adapter = mainCharacterAdapter
            supportingCharacterRecyclerView.adapter = supportingCharacterAdapter
        }
    }

    // Hàm tiện ích để lấy chi tiết anime dựa vào tiêu đề
    private fun getAnimeDetail(animeTitle: String?): Detail? {
        return when (animeTitle) {
            "Bocchi The Rock" -> Detail(
                title = "Bocchi The Rock",
                animeImage = R.drawable.img, // Đảm bảo hình ảnh anime có tên đúng
                mainCharacters = listOf(
                    Character("Gotou, Hitori", R.drawable.img_8),
                    Character("Yamada, Ryou", R.drawable.img_9),
                    Character("Ijichi, Nijika", R.drawable.img_7),
                    Character("Kita, Ikuyo", R.drawable.img_10)
                ),
                supportingCharacters = listOf(
                    Character("Kikuri Hiroi", R.drawable.img_11),
                    Character("Futari Gotou", R.drawable.img_12),
                    Character("Seika Ijichi", R.drawable.img_13),
                    Character("PA-san", R.drawable.img_14),
                    Character("Naoki Gotou", R.drawable.img_16),
                    Character("Michiyo Gotou", R.drawable.img_15)
                )
            )
            "Kage no Jitsuryokusha ni Naritakute!" -> Detail(
                title = "Kage no Jitsuryokusha ni Naritakute!",
                animeImage = R.drawable.img_1, // Đảm bảo hình ảnh anime có tên đúng
                mainCharacters = listOf(
                    Character("Cid Kagenou", R.drawable.img_17)

                ),
                supportingCharacters = listOf(
                    Character("Alpha", R.drawable.img_18),
                    Character("Beta", R.drawable.img_19),
                    Character("Delta", R.drawable.img_20),
                    Character("Epsilon", R.drawable.img_21),
                    Character("Eta", R.drawable.img_22),
                    Character("Gamma", R.drawable.img_23)
                )
            )
            "KonoSuba: God's Blessing on This Wonderful World!" -> Detail(
                title = "KonoSuba: God's Blessing on This Wonderful World!",
                animeImage = R.drawable.img_2, // Đảm bảo hình ảnh anime có tên đúng
                mainCharacters = listOf(
                    Character("Kazuma Satou", R.drawable.img_24),
                    Character("Aqua", R.drawable.img_26),
                    Character("Megumin", R.drawable.img_25),
                    Character("Lalatina Ford Dustiness", R.drawable.img_27)

                ),
                supportingCharacters = listOf(
                )
            )
            else -> null
        }
    }
}

