package com.example.marvel.network

import com.example.marvel.model.criadores.RespostaCriadores
import com.example.marvel.model.personagens.RespostaPersonagens
import com.example.marvel.model.quadrinhos.RespostaQuadrinhos
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceMarvel {

    @GET("characters")
    suspend fun getServiceCharacters(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
            ) : RespostaPersonagens

    @GET("comics")
    suspend fun getServiceComics(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
            ) : RespostaQuadrinhos

    @GET("creators")
    suspend fun getServiceCreators(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
    ) : RespostaCriadores
}