package com.hernelio.apptriki1activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.hernelio.apptriki1activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var jugador = "X" // Inicia con el jugador X


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun jugarTriki(view: View) {
        val imageView = view as ImageView
       // // Verifica si la imagen de la ImageView es igual a "empty"
        if (imageView.drawable.constantState == resources.getDrawable(R.drawable.empty).constantState){
            // Cambia la imagen según el turno actual
            if (jugador == "X") {
                imageView.setImageResource(R.drawable.equix)

            } else {
                imageView.setImageResource(R.drawable.oo)
            }

            // Cambia al siguiente jugador
            jugador = if (jugador == "X") "O" else "X"
        }
    }

    fun resetGame(view: View) {
        // Limpia todas las ImageView para que muestren la imagen vacía
        val imageViews = arrayOf(
            binding.imageView1, binding.imageView2, binding.imageView3,
            binding.imageView4, binding.imageView5, binding.imageView6,
            binding.imageView7, binding.imageView8, binding.imageView9
        )

        for (imageView in imageViews) {
            imageView.setImageResource(R.drawable.empty)
        }

        // Restablece el jugador actual al inicio
        jugador = "X"
    }
}