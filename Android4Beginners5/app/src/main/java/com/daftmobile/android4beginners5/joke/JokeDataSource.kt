package com.daftmobile.android4beginners5.joke

interface JokeDataSource {

    fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit)
}
