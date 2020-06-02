package com.example.marvel.repository

import com.example.marvel.model.personagens.RespostaPersonagens
import com.example.marvel.network.RetroInit
import com.example.marvel.network.ServiceMarvel
import com.example.marvel.util.AppUse.md5

class RepositoryMarvel {
    private var url = "https://gateway.marvel.com/v1/public/"
    private var privateKey = "ceac13aef2089eaf3c704ba9da60cf2156b60912"
    private var publicKey = "fe81c0a4bd6c7f00e3df25d68d8d8a92"
    var ts: String = (System.currentTimeMillis() / 1000).toString()
    var hash: String = md5(ts+privateKey+publicKey)
    private var service = ServiceMarvel::class

    //realizando a conexão com a api atraves do retroInit
    private var serviceInit = RetroInit(url).create(service)

    suspend fun getCharacters() : RespostaPersonagens {
        return serviceInit.getServiceCharacters(ts, hash, publicKey)
    }
}