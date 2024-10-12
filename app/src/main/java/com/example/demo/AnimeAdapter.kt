package com.example.demo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.Not_Stagger.MainActivity2


class AnimeAdapter(private val animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animeImage: ImageView = itemView.findViewById(R.id.item_anh)
        val animeTitle: TextView = itemView.findViewById(R.id.item_tieude)
        val animeStudio: TextView = itemView.findViewById(R.id.item_studio)
        val animeYear: TextView = itemView.findViewById(R.id.item_nam_san_xuat)

        fun bind(anime: Anime, context: Context) {
            animeTitle.text = anime.title
            animeImage.setImageResource(anime.imageUrl)
            animeStudio.text = "Studio: ${anime.studio}"
            animeYear.text = "Năm: ${anime.year}"

            // Thiết lập OnClickListener cho itemView
            itemView.setOnClickListener {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("ANIME_TITLE", anime.title)
                context.startActivity(intent)
                Log.d("AnimeAdapter", "Anime clicked: ${anime.title}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.my_item, parent, false)
        return AnimeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.bind(anime, holder.itemView.context)
    }

    override fun getItemCount(): Int = animeList.size
}
