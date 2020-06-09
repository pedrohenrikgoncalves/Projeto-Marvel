package com.example.marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel.model.creators.Creators
import com.example.marvel.model.events.Events
import com.example.marvel.model.characters.Characters
import com.example.marvel.model.comics.Comic
import com.example.marvel.repository.RepositoryMarvel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class ViewModelMarvel : ViewModel() {

    val listCharacter = MutableLiveData<MutableSet<Characters>>()
    val loading = MutableLiveData<Boolean>()
    private val repositoryMarvel = RepositoryMarvel()


    fun getAllCharacters() = CoroutineScope(IO).launch {
        repositoryMarvel.getCharacters().let {
            listCharacter.postValue(it.data.results)
            loading.postValue(true)
        }
        loading.postValue(false)
    }

    val listComics = MutableLiveData<MutableSet<Comic>>()
    private val repositorMarvel = RepositoryMarvel()

    fun getAllComics() = CoroutineScope(IO).launch {
        loading.postValue(true)
        repositorMarvel.getComics().let {
            listComics.postValue(it.data.results)
        }
        loading.postValue(false)
    }

    val listCreators = MutableLiveData<MutableSet<Creators>>()
    private val repositoMarvel = RepositoryMarvel()

    fun getAllCreators() = CoroutineScope(IO).launch {
        loading.postValue(true)
        repositoMarvel.getCreators().let {
            listCreators.postValue(it.data.results)
        }
        loading.postValue(false)
    }

    val listEvents = MutableLiveData<MutableSet<Events>>()
    private  val repositMarvel = RepositoryMarvel()

    fun getAllEvents() = CoroutineScope(IO).launch {
        loading.postValue(true)
        repositMarvel.getEvents().let {
            listEvents.postValue(it.data.results)
        }
        loading.postValue(false)
    }
}
