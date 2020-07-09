package com.example.marvel.data

import androidx.room.*
import com.example.marvel.model.characters.CharacterRoom


@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    suspend fun getAllListRoom(): MutableList<CharacterRoom>

    @Query("SELECT * FROM characters where id LIKE  :id")
    suspend fun getIdRoom(id: Int): CharacterRoom

    @Insert
    suspend fun insert(vararg characterRoom: CharacterRoom)

    @Delete
    suspend fun delete(vararg characterRoom: CharacterRoom)

    @Update
    suspend fun update(characterRoom: CharacterRoom)
}