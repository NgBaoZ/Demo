package com.example.demo.Real_Stagger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class ImageAdapter(private val imageResIds: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.real_stagger, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageResIds.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        // Gán hình ảnh từ danh sách hình ảnh
        holder.imageView.setImageResource(imageResIds[position])
    }
}

