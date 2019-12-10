package com.daftmobile.android4beginners5.joke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners5.VendingViewModel
import com.daftmobile.android4beginners5.joke.gson.GsonJokeFetcher

class JokeVendingViewModel : ViewModel(), VendingViewModel {
    private val jokeDataSource: JokeDataSource = GsonJokeFetcher()

    private val responseLiveData = MutableLiveData<String>()
    private val errorLiveData = MutableLiveData<String>()

    override fun itemVended(): LiveData<String> = responseLiveData
    override fun vendingError(): LiveData<String> = errorLiveData
    override fun currentDeposit(): LiveData<Int> = MutableLiveData<Int>()

    override fun depositCoin() = Unit

    override fun vend(item: String) = fetchDataFromApi()

    private fun doSomeThreading() {
        println("Funny stuff from ${Thread.currentThread().name} thread")
        Thread {
            Thread.sleep(3000)
            println("Response from ${Thread.currentThread().name} thread")
            // FIXME: This crashes! You can't call setValue() from outside of the main thread
            responseLiveData.value = "Akuku"
        }.start()
    }

    private fun fetchDataFromApi() {
        jokeDataSource.fetch(responseLiveData::postValue, errorLiveData::postValue)
    }
}
