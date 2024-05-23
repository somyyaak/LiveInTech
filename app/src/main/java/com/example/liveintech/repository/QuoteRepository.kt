package com.example.liveintech.repository

import Models.QuoteList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.liveintech.api.QuoteService

class QuoteRepository(private val quoteService: QuoteService) {
    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes : LiveData<QuoteList>
        get()=  quotesLiveData
    suspend fun getQuotes(page:Int){
        val result = quoteService.getQuotes(page)
        if(result?.body() != null ) {
            quotesLiveData.postValue(result.body())
        }
    }
}
