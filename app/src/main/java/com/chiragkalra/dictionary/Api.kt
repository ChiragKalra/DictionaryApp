package com.chiragkalra.dictionary

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

const val header = "Authorization: Token 78bb251553954d4c34a988e991e28ed8a6be322f"
private val authToken = "78bb251553954d4c34a988e991e28ed8a6be322f"
private val baseUrl = "https://owlbot.info/api/v4/"

interface DictionaryApi {
    @Headers(header)
    @GET("dictionary/{word}")
    fun getResponse(@Path("word")query: String): Call<Response?>
}

object Api {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val dictionaryApi: DictionaryApi by lazy { retrofit.create(DictionaryApi::class.java) }
}