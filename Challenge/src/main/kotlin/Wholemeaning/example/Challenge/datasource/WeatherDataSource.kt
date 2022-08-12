package Wholemeaning.example.Challenge.datasource

import Wholemeaning.example.Challenge.model.City

interface WeatherDataSource {

    fun retrieveCities():Collection<City>
    fun retrieveCity(name:String):City
}