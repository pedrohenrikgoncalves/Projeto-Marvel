package com.example.marvel.network

import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.model.comics.ResultsComics
import com.example.marvel.model.creators.ResultsCreators
import com.example.marvel.model.events.ResultsEvents
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceMarvel {

    @GET("characters")
    suspend fun getServiceCharacters(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
            ) : ResultsCharacters

    @GET("comics")
    suspend fun getServiceComics(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
            ) : ResultsComics

    @GET("creators")
    suspend fun getServiceCreators(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
    ) : ResultsCreators

    @GET("events")
    suspend fun getServiceEvents(
            @Query("ts") ts : String ,
            @Query("hash") hash : String ,
            @Query("apikey") apikey : String
    ) : ResultsEvents
}