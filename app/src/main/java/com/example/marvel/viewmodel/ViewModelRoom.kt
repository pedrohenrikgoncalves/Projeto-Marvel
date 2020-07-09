package com.example.marvel.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel.model.characters.CharacterRoom
import com.example.marvel.repository.RepositoryMarvel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelRoom : ViewModel() {

    val listFav = MutableLiveData<MutableList<CharacterRoom>>()
    private val repository = RepositoryMarvel()
    val loading = MutableLiveData<Boolean>()


    fun getListRoom(context: Context) = CoroutineScope(Dispatchers.IO).launch {
        loading.postValue(true)
        repository.getListRoom(context).let {
            listFav.postValue(it)
            loading.postValue(false)
        }
    }

    fun insertCharacterRoom(context: Context, character: CharacterRoom) =
            CoroutineScope(Dispatchers.IO).launch {
                repository.insertCharacter(context, character)
            }

    fun removeCharacterFav(context: Context, character: CharacterRoom) =
            CoroutineScope(Dispatchers.IO).launch {
                repository.removerTeam(context, character)
            }
}
