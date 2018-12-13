package com.daftmobile.android4beginners6pokedex.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.request()
            .newBuilder()
            .addHeader("x-device-uuid", token)
            .build()
            .let(chain::proceed)
}
