package com.example.dasherquotes.quotes.api

import com.example.dasherquotes.quotes.model.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("quotes")
    suspend fun getGames() : Response<List<Quotes>>
}