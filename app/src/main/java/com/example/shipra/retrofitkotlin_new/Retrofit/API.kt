package com.example.shipra.retrofitkotlin_new.Retrofit

import retrofit2.http.GET
import java.util.*
import com.example.shipra.retrofitkotlin_new.model.model
import io.reactivex.Observable

interface API {

    @get:GET("photos")
    val data:Observable<List<model>>

}