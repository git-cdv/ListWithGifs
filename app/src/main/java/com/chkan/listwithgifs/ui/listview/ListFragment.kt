package com.chkan.listwithgifs.ui.listview

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
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
        Log.d("MYLOGS", "ListFragment -> onCreateView")
        binding = FragmentListBinding.inflate(inflater)

        // Позволяет привязке данных наблюдать за LiveData в течение жизненного цикла этого фрагмента
        binding.lifecycleOwner = this
        binding.viewModel=viewModel

        //назначаем ресайклеру адаптер
        val adapter = GiftListAdapter(GifListListener { gif ->
            viewModel.displayGiftDetails(gif) })
        binding.rvList.adapter = adapter

        viewModel.apiResult.observe(viewLifecycleOwner, Observer {
            Log.d("MYLOGS", "ListFragment : apiResult ->$it")
            when(it){
                is ApiResult.Success -> adapter.data = it.data
                is ApiResult.Error -> {
                    val snackbar = Snackbar.make(binding.root, resources.getText(R.string.error_text), Snackbar.LENGTH_LONG)
                    snackbar.setBackgroundTint(Color.RED).setTextColor(Color.WHITE).show()
                }
            }
        })

        viewModel.navToSelectedGif.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment(it))
                viewModel.displayGifDetailsComplete()
            }
        })

        return binding.root
    }

}