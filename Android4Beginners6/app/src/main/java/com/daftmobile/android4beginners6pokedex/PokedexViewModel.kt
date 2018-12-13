package com.daftmobile.android4beginners6pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher


class PokedexViewModel: ViewModel() {
    private val pokemonFetcher = PokemonFetcher()

    private val pokemonLiveData = MutableLiveData<List<PokemonItem>>()
    private val errorLiveData = MutableLiveData<String>()
    // TODO: loader

    fun pokemonList(): LiveData<List<PokemonItem>> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun refresh() {
        pokemonFetcher.fetchAll({
            pokemonLiveData.value = it.map { PokemonItem(it) }
        }, {
            errorLiveData.setValue(it)
        })
    }

}
