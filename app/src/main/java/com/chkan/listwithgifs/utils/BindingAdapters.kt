package com.chkan.listwithgifs.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {

    Glide.with(imgView.context).load(imgUrl).centerCrop().into(imgView)

}