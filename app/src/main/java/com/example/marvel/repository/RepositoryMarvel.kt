package com.example.marvel.repository

import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.model.comics.ResultsComics
import com.example.marvel.model.creators.ResultsCreators
import com.example.marvel.model.events.ResultsEvents
import com.example.marvel.network.RetroInit
import com.example.marvel.network.ServiceMarvel
import com.example.marvel.util.AppUse.md5

class RepositoryMarvel {
    private var url = "https://gateway.marvel.com/v1/public/"
    private var privateKey = "6a4b25496c18713c3ca0fc8daaef07bbb6e6fa18"
    private var publicKey = "8dd211728410e53bae39204821f2a306"
    var ts: String = (System.currentTimeMillis() / 1000).toString()
    var hash: String = md5(ts+privateKey+publicKey)
    private var service = ServiceMarvel::class

    //realizando a conexão com a api atraves do retroInit
    private var serviceInit = RetroInit(url).create(service)

    suspend fun getCharacters() : ResultsCharacters {
        return serviceInit.getServiceCharacters(ts, hash, publicKey)
    }

    suspend fun getComics() : ResultsComics {
        return serviceInit.getServiceComics(ts, hash, publicKey)
    }

    suspend fun  getCreators() : ResultsCreators {
        return serviceInit.getServiceCreators(ts, hash, publicKey)
    }

    suspend fun getEvents() : ResultsEvents {
        return serviceInit.getServiceEvents(ts, hash, publicKey)
    }
}