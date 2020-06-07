package com.example.marvel.repository

import com.example.marvel.model.criadores.RespostaCriadores
import com.example.marvel.model.personagens.RespostaPersonagens
import com.example.marvel.model.quadrinhos.Quadrinhos
import com.example.marvel.model.quadrinhos.RespostaQuadrinhos
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

    suspend fun getCharacters() : RespostaPersonagens {
        return serviceInit.getServiceCharacters(ts, hash, publicKey)
    }

    suspend fun getComics() : RespostaQuadrinhos {
        return serviceInit.getServiceComics(ts, hash, publicKey)
    }

    suspend fun  getCreators() : RespostaCriadores {
        return serviceInit.getServiceCreators(ts, hash, publicKey)
    }
}