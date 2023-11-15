package com.example.retrofitapp_pokedexpokemon.view

import android.graphics.Color
import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapp_pokedexpokemon.databinding.PokemonItemBinding
import com.example.retrofitapp_pokedexpokemon.domain.Pokemon

class PokemonAdapter(private val items: List<Pokemon?>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(binding)
	}

	override fun getItemCount() = items.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val item = items[position]
		holder.bindView(item)
	}

	class ViewHolder(private val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {

		fun bindView(item: Pokemon?) {
			binding.apply {
				// Menggunakan View Binding untuk mengakses elemen-elemen di dalam layout
				val ivPokemon = ivPokemon
				val tvNumber = tvNumber
				val tvName = tvName
				val tvType1 = tvType1
				val tvType2 = tvType2

				item?.let {
					Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)

					tvNumber.text = "N° ${item.formattedNumber}"
					tvName.text = item.formattedName

					tvType1.setBackgroundColor(parseColor(CheckBackgroundColor(item.types[0].name.capitalize())))
					tvType1.setTextColor(parseColor(CheckColorTextType(CheckBackgroundColor(item.types[0].name.capitalize()))))
					tvType1.text = item.types[0].name.capitalize()

					if (item.types.size > 1) {
						tvType2.visibility = View.VISIBLE
						tvType2.setBackgroundColor(parseColor(CheckBackgroundColor(item.types[1].name.capitalize())))
						tvType2.setTextColor(parseColor(CheckColorTextType(CheckBackgroundColor(item.types[1].name.capitalize()))))
						tvType2.text = item.types[1].name.capitalize()
					} else {
						tvType2.visibility = View.GONE
					}
				}
			}
		}

		private fun CheckBackgroundColor(nameType: String): String {
			return if (nameType == "Bug") {
				"#729F3F"
			} else if (nameType == "Dark") {
				"#707070"
			} else if (nameType == "Dragon") {
				"#53A4Cf"
			} else if (nameType == "Electric") {
				"#EED535"
			} else if (nameType == "Fairy") {
				"#FDB9E9"
			} else if (nameType == "Fighting") {
				"#D56723"
			} else if (nameType == "Fire") {
				"#FD7D24"
			} else if (nameType == "Flying") {
				"#3DC7Ef"
			} else if (nameType == "Ghost") {
				"#7B62A3"
			} else if (nameType == "Grass") {
				"#9BCC50"
			} else if (nameType == "Ground") {
				"#F7DE3F"
			} else if (nameType == "Ice") {
				"#51C4E7"
			} else if (nameType == "Poison") {
				"#B97FC9"
			} else if (nameType == "Psychic") {
				"#F366B9"
			} else if (nameType == "Rock") {
				"#A38C21"
			} else if (nameType == "Steel") {
				"#A38C21"
			} else if (nameType == "Water") {
				"#4592C4"
			} else {
				//If is Normal return this color
				"#A4ACAF"
			}
		}

		private fun CheckColorTextType(hexaBackground: String): String {

			val colorHexadecimal = Color.parseColor(hexaBackground)

			val r = Color.red(colorHexadecimal)
			val g = Color.green(colorHexadecimal)
			val b = Color.blue(colorHexadecimal)

			val luminositi: Int = (r.times(299) + g.times(587) + b.times(114)).floorDiv(1000)

			return if (luminositi < 175) {
				"#FFFFFF"
			} else {
				"#000000"
			}

		}
	}
}