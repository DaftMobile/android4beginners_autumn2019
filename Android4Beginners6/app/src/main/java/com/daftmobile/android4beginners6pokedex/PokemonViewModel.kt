package com.daftmobile.android4beginners6pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher
import com.squareup.picasso.Picasso


class PokemonViewModel: ViewModel() {
    private val pokemonFetcher = PokemonFetcher()

    private val pokemonLiveData = MutableLiveData<PokemonItem>()
    private val errorLiveData = MutableLiveData<String>()
    private val catchButtonEnabled = MutableLiveData<Boolean>()

    fun pokemonInfo(): LiveData<PokemonItem> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData
    fun isCatchButtonEnabled(): LiveData<Boolean> = catchButtonEnabled


    fun setPokemonItem(pokemonItem: PokemonItem) {
        pokemonLiveData.value = pokemonItem
        catchButtonEnabled.value = pokemonItem.name == "Unknown"
    }

    fun catchPokemon() {
        val index = pokemonLiveData.value?.index ?: return
        pokemonFetcher.catch(index, {
            val pokemonItem = PokemonItem(it)
            Picasso.get().invalidate(pokemonItem.imageUrl)
            Picasso.get().invalidate(pokemonItem.thumbnailUrl)
            setPokemonItem(pokemonItem)
        }, {
            errorLiveData.setValue(it)
        })
    }
}
