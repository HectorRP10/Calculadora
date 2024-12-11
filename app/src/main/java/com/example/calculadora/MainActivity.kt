package com.example.calculadora

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            realizarp_oeracion("suma")
        }

        binding.button2.setOnClickListener {
            realizarp_oeracion("resta")
        }

        binding.button3.setOnClickListener {
            realizarp_oeracion("multiplicacion")
        }

        binding.button4.setOnClickListener {
            realizarp_oeracion("division")
        }
    }

    private fun realizarp_oeracion(operacion: String) {
        val numero1 = binding.etNumber1.text.toString()
        val numero2 = binding.etNumber2.text.toString()

        if (numero1.isEmpty() || numero2.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = numero1.toDouble()
        val num2 = numero2.toDouble()

        val resultado: Double = when (operacion) {
            "suma" -> num1 + num2
            "resta" -> num1 - num2
            "multiplicacion" -> num1 * num2
            "division" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                    return
                }
                num1 / num2
            }
            else -> 0.0
        }

        // Mostrar el resultado en el TextView
        binding.textView.text = "Resultado: $resultado"
    }
}
