package com.daftmobile.android4beginners5.joke.gson

import com.daftmobile.android4beginners5.joke.JokeApi
import com.daftmobile.android4beginners5.joke.JokeDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GsonJokeFetcher: JokeDataSource {

    // logujemy cały ruch sieciowy do konsoli
    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    // dodajemy auth header i logowanie do konsoli
    private val client = OkHttpClient.Builder()
            .addInterceptor(AuthHeaderInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .build()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://switter.app.daftmobile.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())  // Gson for JSON
            .build()
    private val jokeApi = retrofit.create(JokeApi::class.java)

    override fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        jokeApi.getJoke().enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!.content)
                } else {
                    onError("Wrócił błąd ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                onError(t.message ?: "Nieznany błąd")
            }
        })
    }
}
