package com.example.liveintech

import Models.QuoteList
import Models.QuotesAdapter
import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liveintech.api.QuoteService
import com.example.liveintech.repository.QuoteRepository
import com.example.liveintech.viewModels.MainViewModel
import com.example.liveintech.viewModels.MainViewModelFactory


class Screen2 : AppCompatActivity() {
    private lateinit var quotesAdapter: QuotesAdapter
    private lateinit var mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)
        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(repository)
        ).get(MainViewModel::class.java)

        quotesAdapter = QuotesAdapter(this, arrayListOf())
        val recyclerView: RecyclerView = findViewById(R.id.itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = quotesAdapter
        mainViewModel.quotes.observe(this, Observer{
            Log.d("ResonseYes", it.results.toString())
            quotesAdapter.update(it.results)
        })
    }

}