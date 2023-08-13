package com.example.lesson

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var spCars: Spinner
    lateinit var spPomps : Spinner
    lateinit var etLiter : TextView
    var secondButton :Button? = null
    lateinit var rgDieselOrGasoline : RadioGroup

    companion object{
        const val LITER = "LITER"
        const val CAR = "CAR"
        const val POMP = "POMP"
        const val FUELTYPE = "FUELTYPE"
    }

    var selectedOption: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        spCars = findViewById(R.id.spCars)
        spPomps = findViewById(R.id.spPomps)
        rgDieselOrGasoline = findViewById(R.id.rgDieselOrGasoline)

        val carsPlateNoAndModelNames = Database.cars.map { "${it.plate}"  }
        spCars.adapter = ArrayAdapter(this,R.layout.tv_custom_spinner_item, carsPlateNoAndModelNames)

        val pomps = Pomps.pomps.map {"${it.id} Numaralı Pompa"}
        spPomps.adapter = ArrayAdapter(this,R.layout.tv_custom_spinner_item, pomps )

        secondButton = findViewById(R.id.secondButton)

        etLiter = findViewById((R.id.etLiter))

        rgDieselOrGasoline.setOnCheckedChangeListener { _, checkedId ->
            selectedOption = when (checkedId) {
                R.id.rbGasoline -> "Benzin"
                R.id.rbDiesel -> "Dizel"
                // Diğer seçeneklere göre güncelleme yapın.
                else -> null
            }
        }


        secondButton!!.setOnClickListener{

            if(!etLiter.text.isNullOrEmpty() &&
                spCars.selectedItem!=null &&
                spPomps.selectedItem!=null){
                val intent = Intent(this,MainActivity3::class.java )
                intent.putExtra(LITER, (etLiter.text.toString()).toDouble())
                intent.putExtra("CAR", spCars.selectedItem.toString())
                intent.putExtra("POMP", spPomps.selectedItem.toString())

                val selectedRadioButtonId = rgDieselOrGasoline.checkedRadioButtonId
                if (selectedRadioButtonId == R.id.rbDiesel) {
                    intent.putExtra(FUELTYPE, "Dizel")
                } else {
                    intent.putExtra(FUELTYPE,"Benzin")
                }
                startActivity(intent)
            }else{

            }

        }





    }
}