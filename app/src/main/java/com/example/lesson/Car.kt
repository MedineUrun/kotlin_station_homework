package com.example.lesson

object Database{
    val cars = mutableListOf(
        Car(1, "27 ABC 123",FuelType.DIESEL ),
        Car(2, "34 SDF 879",FuelType.GASOLINE ),
        Car(3, "46 HJG 456",FuelType.DIESEL ),
        Car(4, "28 GFG 147",FuelType.GASOLINE ),
        Car(5, "02 ERT 057",FuelType.GASOLINE ),
    )
}

object Pomps{
    val pomps = mutableListOf(
        Pomp(1,40.00),
        Pomp(2,21.00),
        Pomp(3,16.00),
        Pomp(4,12.00),
        Pomp(5,32.00),
    )
}

data class Pomp(val id:Int, val litre:Double){
}

data class Car(val id:Int, val plate:String, val fuelType:FuelType){
}

enum class FuelType{
    GASOLINE,
    DIESEL
}
