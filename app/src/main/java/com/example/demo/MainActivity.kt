package com.example.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimeAdapter
    private lateinit var newanimeList: MutableList<Anime>
    lateinit var imageId: IntArray
    lateinit var heading: ArrayList<String>
    lateinit var studio: ArrayList<String>
    lateinit var year: ArrayList<String>
    lateinit var chitiet: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo đúng các biến
        heading = arrayListOf("Bocchi The Rock",
            "Kage no Jitsuryokusha ni Naritakute!",
            "KonoSuba: God's Blessing on This Wonderful World!",
            "JoJo no Kimyou na Bouken",
            "Re:Zero kara Hajimeru Isekai Seikatsu",
            "Neon Genesis Evangelion",
            "Mashle: Magic and Muscles")
        studio = arrayListOf("CloverWorks",
            "Nexus",
            "Studio Deen",
            "David Production",
            "White Fox",
            "Production I.G",
            "A-1 Pictures")
        year = arrayListOf("2022",
            "2022",
            "2016",
            "2014",
            "2016",
            "1995",
            "2023")
        imageId = intArrayOf(R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6)




        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        newanimeList = ArrayList<Anime>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val anime = Anime(heading[i], studio[i], year[i], imageId[i])
            newanimeList.add(anime)
        }

        recyclerView.adapter = AnimeAdapter(newanimeList)



    }

}

