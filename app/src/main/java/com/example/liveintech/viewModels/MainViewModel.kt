package com.example.liveintech.viewModels

import Models.QuoteList
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liveintech.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository : QuoteRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
        repository.getQuotes(1)
    }
}
    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}