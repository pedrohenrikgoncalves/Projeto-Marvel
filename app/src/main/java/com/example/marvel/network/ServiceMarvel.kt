package com.example.marvel.network

import com.example.marvel.model.personagens.RespostaPersonagens
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceMarvel {

    @GET("characters")
    suspend fun getServiceCharacters(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
            ) : RespostaPersonagens
}