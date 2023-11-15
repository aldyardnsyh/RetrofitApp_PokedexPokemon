package com.example.retrofitapp_pokedexpokemon.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp_pokedexpokemon.databinding.ActivityMainBinding
import com.example.retrofitapp_pokedexpokemon.domain.Pokemon
import com.example.retrofitapp_pokedexpokemon.viewModel.PokemonViewModel
import com.example.retrofitapp_pokedexpokemon.viewModel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

	// Gunakan View Binding
	private lateinit var binding: ActivityMainBinding

	private val viewModel by lazy {
		ViewModelProvider(this, PokemonViewModelFactory()).get(PokemonViewModel::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		// Inisialisasi View Binding
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)

		supportActionBar?.hide()

		setupRecyclerView()

		viewModel.pokemons.observe(this, Observer {
			loadRecyclerView(it)
		})
	}

	private fun setupRecyclerView() {
		// Menggunakan View Binding untuk mengakses RecyclerView
		binding.rvPokemons.layoutManager = LinearLayoutManager(this)
	}

	private fun loadRecyclerView(pokemons: List<Pokemon?>) {
		// Menggunakan View Binding untuk mengakses RecyclerView dan Adapter
		binding.rvPokemons.adapter = PokemonAdapter(pokemons)
	}
}