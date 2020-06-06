package com.example.marvel.model.quadrinhos

data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: MutableSet<Quadrinhos>,
        val total: Int
)