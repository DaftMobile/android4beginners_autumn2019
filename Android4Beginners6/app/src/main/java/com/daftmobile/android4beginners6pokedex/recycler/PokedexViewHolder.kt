package com.daftmobile.android4beginners6pokedex.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daftmobile.android4beginners6pokedex.PokemonItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_recycler_view_item.view.*

class PokedexViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView = itemView.imageView
    private val nameView = itemView.nameView
    private val numberView = itemView.numberView
    private val colorView = itemView.colorView

    fun bindItem(pokemonItem: PokemonItem, onItemClicked: (PokemonItem) -> Unit) {
        nameView.text = pokemonItem.name
        numberView.text = pokemonItem.numberLabel
        colorView.setBackgroundColor(pokemonItem.color)
        Picasso.get()
                .load(pokemonItem.thumbnailUrl)
                .into(imageView)
        itemView.setOnClickListener { onItemClicked(pokemonItem) }
    }
}
