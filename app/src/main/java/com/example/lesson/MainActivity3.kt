package com.example.lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    lateinit var tvPrice : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        tvPrice = findViewById(R.id.tvPrice)

        val selectedCar = intent.getStringExtra(MainActivity2.CAR)
        val selectedLiter = intent.getDoubleExtra(MainActivity2.LITER, 0.0)
        val selectedPomp = intent.getStringExtra(MainActivity2.POMP)
        val selectedRadioGroup = intent.getStringExtra(MainActivity2.FUELTYPE)

        val liter = selectedLiter.toDouble()
        var fuelPricePerLiter = 0.0

        when (selectedRadioGroup) {
            "Benzin" -> fuelPricePerLiter = 36.00
            "Dizel" -> fuelPricePerLiter = 35.50
            // Add more cases if you have additional fuel types
        }

        val totalPrice = liter * fuelPricePerLiter


      tvPrice.text = "${selectedPomp} 'dan\n" +
              "${selectedCar} Plakalı aracınıza" +
              " ${selectedLiter} Litre ${selectedRadioGroup} türünde yakıt aldınız.\n"+
              "Yapmanız gereken ödeme tutarı: ${totalPrice} ₺"

}
}

