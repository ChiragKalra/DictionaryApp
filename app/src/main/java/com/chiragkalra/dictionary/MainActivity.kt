package com.chiragkalra.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chiragkalra.dictionary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: DictionaryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.outputRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.inputEditText.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                val queryString = binding.inputEditText.text.toString()
                viewModel.getResults(queryString) {
                    if (it == null) return@getResults
                    binding.outputRecyclerView.adapter = RecyclerViewAdaptor(it)
                }
                return@setOnKeyListener true
            } else {
                return@setOnKeyListener false
            }
        }


    }
}