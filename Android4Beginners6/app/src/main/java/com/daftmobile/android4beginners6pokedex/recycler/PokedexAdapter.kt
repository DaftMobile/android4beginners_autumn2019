package com.daftmobile.android4beginners6pokedex.recycler

import com.daftmobile.android4beginners6pokedex.PokemonItem

class PokedexAdapter(
    var items: List<PokemonItem>,
    private val onItemClicked: (PokemonItem) -> Unit
) {
    // TODO: implement
}
