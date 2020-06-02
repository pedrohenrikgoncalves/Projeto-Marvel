package com.example.marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel.model.personagens.Personagem
import com.example.marvel.repository.RepositoryMarvel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelMarvel : ViewModel() {

    val listCharacter = MutableLiveData<MutableSet<Personagem>>()
    private val repositoryMarvel = RepositoryMarvel()


    fun getAllCharacters() = CoroutineScope(IO).launch {
        repositoryMarvel.getCharacters().let {
            listCharacter.postValue(it.data.results)
        }
    }
}