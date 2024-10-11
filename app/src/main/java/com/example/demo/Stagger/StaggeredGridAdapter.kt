package com.example.demo.Stagger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StaggeredGridAdapter(private val characterList: List<Detail>) : RecyclerView.Adapter<StaggeredGridAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.demo.R.layout.staggered_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = characterList[position]

        // Thiết lập dữ liệu cho tiêu đề và hình ảnh phim
        holder.movieTitle.text = movie.title
        holder.movieImage.setImageResource(movie.animeImage)

        // Cập nhật RecyclerView cho danh sách nhân vật chính
        val mainCharacterAdapter = CharacterAdapter(movie.mainCharacters)
        holder.mainCharacterRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.mainCharacterRecyclerView.adapter = mainCharacterAdapter

        // Cập nhật RecyclerView cho danh sách nhân vật phụ
        val supportingCharacterAdapter = CharacterAdapter(movie.supportingCharacters)
        holder.supportingCharacterRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.supportingCharacterRecyclerView.adapter = supportingCharacterAdapter
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(com.example.demo.R.id.staggered_title)
        val movieImage: ImageView = itemView.findViewById(com.example.demo.R.id.staggered_image)
        val mainCharacterRecyclerView: RecyclerView = itemView.findViewById(com.example.demo.R.id.main_character_recyclerview)
        val supportingCharacterRecyclerView: RecyclerView = itemView.findViewById(com.example.demo.R.id.supporting_character_recyclerview)
    }
}

