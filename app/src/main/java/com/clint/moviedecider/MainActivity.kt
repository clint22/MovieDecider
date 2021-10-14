package com.clint.moviedecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.clint.moviedecider.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieList = arrayListOf(
        "Inception",
        "Batman begins",
        "Fight club",
        "Lord of the rings",
        "Good will hunting"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonDecideMovie.setOnClickListener {
            val randomMovie = Random().nextInt(movieList.count())
            binding.textViewSelectedMovie.text = movieList[randomMovie]
        }

        binding.buttonAddMovie.setOnClickListener {
            if (binding.editTextTextAddMovieName.text.isNotEmpty()) {
                val newMovie = binding.editTextTextAddMovieName.text.toString()
                movieList.add(newMovie)
                binding.editTextTextAddMovieName.text.clear()
                println("movieList $movieList")
            } else {
                Toast.makeText(this, "Please enter a movie name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
