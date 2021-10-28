package com.chkan.listwithgifs.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.chkan.listwithgifs.R
import com.google.android.material.appbar.MaterialToolbar

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_detail, container, false)
        val imgView : ImageView = v.findViewById(R.id.detail_image)

        val gif = DetailFragmentArgs.fromBundle(requireArguments()).gifSelected

        val imgUrl = gif.images.largeSize.url

        Glide.with(this).load(imgUrl).into(imgView)

        val toolbar : MaterialToolbar = v.findViewById(R.id.detail_toolbar)
        toolbar.title = gif.title
        toolbar.setNavigationOnClickListener {findNavController().popBackStack()}

        return v
    }

}