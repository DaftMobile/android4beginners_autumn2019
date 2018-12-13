package com.daftmobile.android4beginners6pokedex

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private val viewModel: PokedexViewModel by viewModels()
    // TODO create Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPicasso()
        // TODO hook adapter
        viewModel.pokemonList().observe(this, Observer(this::updatePokemonList))
        viewModel.error().observe(this, Observer(this::showError))
        viewModel.refresh()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.refresh()
    }

    private fun updatePokemonList(pokemonList: List<PokemonItem>?) {
        if (pokemonList == null) return
        // TODO update adapter
    }

    private fun showPokemonActivity(pokemon: PokemonItem) {
        val intent = Intent(this, PokemonActivity::class.java)
                .putExtra(PokemonActivity.EXTRA_KEY, pokemon)
        startActivity(intent)
    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun setupPicasso() {
        val picasso = Picasso.Builder(this)
                .downloader(OkHttp3Downloader(PokemonFetcher.HTTP_CLIENT))
                .build()
        Picasso.setSingletonInstance(picasso)
    }
}
