package com.example.elvinPrak.data.api

import com.example.elvinPrak.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}