package com.example.marvel.model.creators

data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Creators>,
        val total: Int
)