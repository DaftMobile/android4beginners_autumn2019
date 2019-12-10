@file:Suppress("unused")

package com.daftmobile.android4beginners5.joke

import com.daftmobile.android4beginners5.joke.gson.Joke
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface JokeApi {
    @GET("/api/hello")
    fun greetings(): Call<ResponseBody>

    @GET("/api/joke")
    fun getJoke(): Call<Joke>
}
