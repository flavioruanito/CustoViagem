package com.example.custoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.custoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)


    }


    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }

    }


    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)


    }

    fun calculate() {

        if (isValid()) {

            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat() //Pegando valor Preço
            val Autonomy = binding.editAutonomy.text.toString().toFloat() // Pegando valor de autonomia

            val totalValue = (distance * price) / Autonomy // caulculo da regra de negocio
            // val totalValueStr = "  Formatando o valor R$ com duas casas decimais //

            binding.textTotalValue.text = "R$: ${"%.2f".format(totalValue)}"


        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

        }


    }


}


