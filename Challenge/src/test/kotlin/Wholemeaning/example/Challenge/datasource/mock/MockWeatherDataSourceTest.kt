package Wholemeaning.example.Challenge.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockWeatherDataSourceTest{
    private val mockDataSource: MockWeatherDataSource = MockWeatherDataSource()
    @Test
    fun`should provide a collection of cities`(){


        val cities = mockDataSource.retrieveCities()
        assertThat(cities).isNotEmpty
    }

    @Test
    fun `should provide some mock data`(){
        val cities = mockDataSource.retrieveCities()

        assertThat(cities).allSatisfy { it.startTime.isNotBlank() }
    }
}