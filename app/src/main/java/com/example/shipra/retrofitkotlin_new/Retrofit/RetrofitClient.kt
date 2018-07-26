package com.example.shipra.retrofitkotlin_new.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Array.get

object RetrofitClient {

private  var ourinstance:Retrofit?=null

    val instance:Retrofit
    get(){

        if(ourinstance==null)
            ourinstance=Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

        return  ourinstance!!
    }
}