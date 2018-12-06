package com.daftmobile.android4beginners5

import androidx.lifecycle.LiveData

interface VendingViewModel {
    fun currentDeposit(): LiveData<Int>
    fun itemVended(): LiveData<String>
    fun vendingError(): LiveData<String>
    fun depositCoin()
    fun vend(item: String)
}
