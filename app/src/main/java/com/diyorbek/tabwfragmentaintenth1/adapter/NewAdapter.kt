package com.diyorbek.tabwfragmentaintenth1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.tabwfragmentaintenth1.databinding.PhotoSampleBinding
import com.diyorbek.tabwfragmentaintenth1.model.Photo

class NewAdapter : ListAdapter<Photo, NewAdapter.ImageViewHolder>(DiffCallBack()) {
    lateinit var onClick: (Photo) -> Unit

    private class DiffCallBack : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.icon == newItem.icon
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    inner class ImageViewHolder(private val binding: PhotoSampleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.apply {
                image.setImageResource(photo.icon)
            }
            itemView.setOnClickListener {
                onClick.invoke(photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            PhotoSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}