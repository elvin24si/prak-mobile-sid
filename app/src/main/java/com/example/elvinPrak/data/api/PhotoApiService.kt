package com.example.elvinPrak.data.api

import com.example.elvinPrak.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}