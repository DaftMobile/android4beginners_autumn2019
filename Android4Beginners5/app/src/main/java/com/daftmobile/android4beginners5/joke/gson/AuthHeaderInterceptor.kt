package com.daftmobile.android4beginners5.joke.gson

import okhttp3.Interceptor
import okhttp3.Response

class AuthHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
                .addHeader("x-device-uuid", "qwertyuiop")
                .build()
        return chain.proceed(request)
    }
}
