package Wholemeaning.example.Challenge.service

import Wholemeaning.example.Challenge.datasource.WeatherDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CityServiceTest{
    private val dataSource: WeatherDataSource = mockk(relaxed = true)
    private val cityService= CityService(dataSource)

    @Test
    fun`should call its data source to retrieve banks `(){

        val cities = cityService.getCities()
        verify (exactly = 1){ dataSource.retrieveCities() }


    }
}