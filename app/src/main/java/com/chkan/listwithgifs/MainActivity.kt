package com.chkan.listwithgifs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.chkan.listwithgifs.ui.listview.ListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null){
            viewModel.getGifList()
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}