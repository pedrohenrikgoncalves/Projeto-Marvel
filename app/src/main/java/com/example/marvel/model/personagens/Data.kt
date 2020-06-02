package com.example.marvel.model.personagens

data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Personagem>,
        val total: Int
)