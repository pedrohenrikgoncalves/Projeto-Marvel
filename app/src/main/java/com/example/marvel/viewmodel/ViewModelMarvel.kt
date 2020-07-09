package com.example.marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.model.comics.ResultsComics
import com.example.marvel.model.creators.ResultsCreators
import com.example.marvel.model.events.ResultsEvents
import com.example.marvel.repository.RepositoryMarvel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class ViewModelMarvel : ViewModel() {

    val listCharacter = MutableLiveData<MutableSet<ResultsCharacters.Data.Characters>>()
    val loading = MutableLiveData<Boolean>()
    private val repositoryMarvel = RepositoryMarvel()


    fun getAllCharacters() = CoroutineScope(IO).launch {
        repositoryMarvel.getCharacters().let {
            val personagens = it.data?.results
            val personagensFinoDoFino = mutableSetOf<ResultsCharacters.Data.Characters>()
            val imagemPadrao = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available"
            val imagemPadraoDois = "http://i.annihil.us/u/prod/marvel/i/mg/5/e0/4c0035c9c425d"
            personagens?.forEach {
                if (it.thumbnail?.path != imagemPadrao && it.thumbnail?.path != imagemPadraoDois) {
                    personagensFinoDoFino.add(it)
                }
            }
            listCharacter.postValue(personagensFinoDoFino)
            loading.postValue(true)
        }
        loading.postValue(false)
    }

    val listComics = MutableLiveData<MutableSet<ResultsComics.Data.Comics>>()
    private val repositorMarvel = RepositoryMarvel()

    fun getAllComics() = CoroutineScope(IO).launch {
        repositorMarvel.getComics().let {
            val quadrinhos = it.data?.results
            val quadrinhosFinoDoFino = mutableSetOf<ResultsComics.Data.Comics>()
            val imagemQuadinhos = "http://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75"
            quadrinhos?.forEach {
                if (it.thumbnail?.path != imagemQuadinhos) {
                    quadrinhosFinoDoFino.add(it)
                }
            }
            listComics.postValue(quadrinhosFinoDoFino)
            loading.postValue(true)
        }
        loading.postValue(false)
    }

    val listCreators = MutableLiveData<MutableSet<ResultsCreators.Data.Creators>>()
    private val repositoMarvel = RepositoryMarvel()

    fun getAllCreators() = CoroutineScope(IO).launch {
        loading.postValue(true)
        repositoMarvel.getCreators().let {
            listCreators.postValue(it.data?.results)
        }
        loading.postValue(false)
    }

    val listEvents = MutableLiveData<MutableSet<ResultsEvents.Data.Events>>()
    private val repositMarvel = RepositoryMarvel()

    fun getAllEvents() = CoroutineScope(IO).launch {
        loading.postValue(true)
        repositMarvel.getEvents().let {
            listEvents.postValue(it.data?.results)
        }
        loading.postValue(false)
    }
}
