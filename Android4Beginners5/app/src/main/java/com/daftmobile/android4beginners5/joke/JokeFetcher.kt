package com.daftmobile.android4beginners5.joke

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class JokeFetcher: JokeDataSource {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://switter.app.daftmobile.com/")
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
            .build()

    private val jokeApi = retrofit.create(JokeApi::class.java)

    override fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit) {
//        call.execute
    }
}
