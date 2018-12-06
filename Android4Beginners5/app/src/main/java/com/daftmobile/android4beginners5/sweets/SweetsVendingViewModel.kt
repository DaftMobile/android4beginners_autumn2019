package com.daftmobile.android4beginners5.sweets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners5.VendingViewModel

class SweetsVendingViewModel : ViewModel(), VendingViewModel {
    private val vendingMachine = ChocoBarVendingMachine()
    private val chocolateBarLiveData = MutableLiveData<String>()
    private val depositLiveData = MutableLiveData<Int>()
    private val errorLiveData = MutableLiveData<String>()

    override fun currentDeposit(): LiveData<Int> = depositLiveData
    override fun itemVended(): LiveData<String> = chocolateBarLiveData
    override fun vendingError(): LiveData<String> = errorLiveData

    init {
        refreshDeposit()
    }

    override fun depositCoin() {
        vendingMachine.depositCoin()
        refreshDeposit()
    }

    override fun vend(item: String) {
        val bar = vendingMachine.vend(item)
        chocolateBarLiveData.value = bar.name
        refreshDeposit()
    }

    private fun refreshDeposit() {
        depositLiveData.value = vendingMachine.getCurrentDeposit()
    }
}
