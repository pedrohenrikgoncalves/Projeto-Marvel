package com.example.marvel.model.characters

data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Characters>,
        val total: Int
)