package com.devanand.enficapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devanand.enficapp.databinding.ActivityMainBinding
import com.devanand.enficapp.viewmodel.UserViewModal
import com.example.myapplication.adapter.UserDataAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel : UserViewModal by viewModels()
    private lateinit var adapter : UserDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.userData.observe(this,Observer{ data ->

            val dataList = data.toList()
            adapter =UserDataAdapter(dataList)
            binding.rv.layoutManager =LinearLayoutManager(this)
            binding.rv.adapter = adapter
        })

    }
}