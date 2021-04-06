package com.example.kotlinexample1

data class Villager(val name: String, val birthday: String, val phrase: String, var houseURL: String,
                    val villagerURL: String, var showHouse : Boolean) {
    //toString
    //  Villager(name="Henry",birthday="..",...)
    //geters
    //setters
    //equals
}

//val does not come with setters, var does