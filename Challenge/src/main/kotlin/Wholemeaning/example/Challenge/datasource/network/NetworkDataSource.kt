package Wholemeaning.example.Challenge.datasource.network

import Wholemeaning.example.Challenge.datasource.WeatherDataSource
import Wholemeaning.example.Challenge.datasource.network.dto.CityList
import Wholemeaning.example.Challenge.model.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
): WeatherDataSource{
    override fun retrieveCities(): Collection<City> {
        val response: ResponseEntity<CityList> =
            restTemplate.getForEntity("https://api.tomorrow.io/v4/timelines")
        return response.body?.results
            ?: throw IOException("could not fetch data from the network")
    }


    override fun retrieveCity(name: String): City {
        TODO()

    }
}