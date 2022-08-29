package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.R
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.data.UnsplashPhoto
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.databinding.ItemSplashBinding

// it's special adapter that know how to handle paging data
class UnsplashPhotoPagingAdapter :
    PagingDataAdapter<UnsplashPhoto, UnsplashPhotoPagingAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    class PhotoViewHolder(private val binding: ItemSplashBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: UnsplashPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.gradient)
                    .into(imageView)
            }
        }

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemSplashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }


    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto
            ) = oldItem == newItem

        }
    }
}