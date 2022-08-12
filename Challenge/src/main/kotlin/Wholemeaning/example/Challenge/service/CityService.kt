package Wholemeaning.example.Challenge.service

import Wholemeaning.example.Challenge.datasource.WeatherDataSource
import Wholemeaning.example.Challenge.model.City
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class CityService(@Qualifier("network") val dataSource: WeatherDataSource) {
    fun getCities(): Collection<City> = dataSource.retrieveCities()

    fun getCity(name: String): City = dataSource.retrieveCity(name)

    }
