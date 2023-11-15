package com.example.retrofitapp_pokedexpokemon.domain

import java.util.Locale

data class Pokemon (
	val number: Int,
	val name: String,
	val types: List<PokemonType>
) {
	val formattedName = name.uppercaseFirstLetter()
	val formattedNumber = number.toString().padStart(3, '0')

	val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$formattedNumber.png"

	private fun String.uppercaseFirstLetter(): String {
		return this.capitalize(Locale.getDefault())
	}
}