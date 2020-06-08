package com.example.marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel.model.criadores.Criadores
import com.example.marvel.model.eventos.Eventos
import com.example.marvel.model.personagens.Personagens
import com.example.marvel.model.quadrinhos.Comic
import com.example.marvel.repository.RepositoryMarvel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class ViewModelMarvel : ViewModel() {

    val listCharacter = MutableLiveData<MutableSet<Personagens>>()
    val loading = MutableLiveData<Boolean>()
    private val repositoryMarvel = RepositoryMarvel()


    fun getAllCharacters() = CoroutineScope(IO).launch {
        repositoryMarvel.getCharacters().let {
            listCharacter.postValue(it.data.results)
        }
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

    val listCreators = MutableLiveData<MutableSet<Criadores>>()
    private val repositoMarvel = RepositoryMarvel()

    fun getAllCreators() = CoroutineScope(IO).launch {
        repositoMarvel.getCreators().let {
            listCreators.postValue(it.data.results)
        }
    }

    val listEvents = MutableLiveData<MutableSet<Eventos>>()
    private  val repositMarvel = RepositoryMarvel()

    fun getAllEvents() = CoroutineScope(IO).launch {
        repositMarvel.getEvents().let {
            listEvents.postValue(it.data.results)
        }
    }
}
