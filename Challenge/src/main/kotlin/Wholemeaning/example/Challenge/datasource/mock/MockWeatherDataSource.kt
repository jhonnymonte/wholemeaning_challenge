package Wholemeaning.example.Challenge.datasource.mock

import Wholemeaning.example.Challenge.datasource.WeatherDataSource
import Wholemeaning.example.Challenge.model.City
import org.springframework.stereotype.Repository

@Repository
class MockWeatherDataSource : WeatherDataSource{

    val cities = listOf(City("sidney", "2022-08-12T12:00:00Z", 19.69),
    City("santiago", "2022-08-12T12:12:00Z", 21.69),
    City("georgia", "2022-08-12T12:20:00Z", 12.69))

    override fun retrieveCities(): Collection<City> = cities

    override fun retrieveCity(name: String): City = cities.first{it.name == name}

}
