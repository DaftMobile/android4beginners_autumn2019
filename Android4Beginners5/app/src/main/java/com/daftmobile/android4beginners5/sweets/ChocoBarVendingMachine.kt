package com.daftmobile.android4beginners5.sweets

class ChocoBarVendingMachine {

    private val itemsCount = mutableMapOf(
        Bar(name = "Princess Polo", price = 4) to 2,
        Bar(name = "Venus", price = 3) to 3,
        Bar(name = "Silky Way", price = 2) to 2
    )
    private var deposit = 0

    fun getCurrentDeposit() = deposit

    fun depositCoin() {
        deposit++
    }

    @Throws(ItemNotFoundException::class, OutOfStockException::class, InsufficientFundsException::class)
    fun vend(itemName: String): Bar {
        val item = itemsCount.keys.find { it.name == itemName } ?: throw ItemNotFoundException(itemName)
        if (itemsCount.getValue(item) <= 0) throw OutOfStockException(item.name)
        if (item.price > deposit) throw InsufficientFundsException(item.price)
        itemsCount[item] = itemsCount.getValue(item) - 1
        deposit -= item.price
        return item.copy()
    }
}
