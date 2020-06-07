package com.example.marvel.model.criadores

data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Criadores>,
        val total: Int
)