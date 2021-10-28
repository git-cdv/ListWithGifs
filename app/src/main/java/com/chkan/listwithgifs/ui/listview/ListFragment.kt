package com.chkan.listwithgifs.ui.listview

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.chkan.listwithgifs.R
import com.chkan.listwithgifs.databinding.FragmentListBinding
import com.chkan.listwithgifs.network.ApiResult
import com.google.android.material.snackbar.Snackbar


class ListFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel=viewModel

        val adapter = GiftListAdapter(GifListListener { gif ->
            viewModel.displayGiftDetails(gif) })
        binding.rvList.adapter = adapter

        viewModel.apiResult.observe(viewLifecycleOwner, {
            when(it){
                is ApiResult.Success -> adapter.data = it.data
                is ApiResult.Error -> {
                    val snackbar = Snackbar.make(binding.root, resources.getText(R.string.error_text), Snackbar.LENGTH_LONG)
                    snackbar.setBackgroundTint(Color.RED).setTextColor(Color.WHITE).show()
                }
            }
        })

        viewModel.navToSelectedGif.observe(viewLifecycleOwner, {
            if ( null != it ) {
                this.findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment(it))
                viewModel.displayGifDetailsComplete()
            }
        })

        return binding.root
    }

}