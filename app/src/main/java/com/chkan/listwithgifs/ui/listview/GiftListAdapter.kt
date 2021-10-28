package com.chkan.listwithgifs.ui.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chkan.listwithgifs.R
import com.chkan.listwithgifs.databinding.RvListItemBinding
import com.chkan.listwithgifs.model.Gif

class GiftListAdapter (private val clickListener: GifListListener)
    : RecyclerView.Adapter<GiftListAdapter.MyViewHolder>() {

    var data = listOf<Gif>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(val binding: RvListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gif: Gif, clickListener: GifListListener) {
            binding.gif=gif
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RvListItemBinding =
            DataBindingUtil.inflate(inflater,R.layout.rv_list_item, parent, false)
        return MyViewHolder(binding)
    }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position],clickListener)
    }

    override fun getItemCount() = data.size

}

class GifListListener (val clickListener: (gif: Gif) -> Unit) {
    fun onClick(gif: Gif) = clickListener(gif)
}