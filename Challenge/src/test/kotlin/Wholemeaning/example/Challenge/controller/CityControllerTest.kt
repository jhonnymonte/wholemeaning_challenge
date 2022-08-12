package Wholemeaning.example.Challenge.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class CityControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return a city`(){
        mockMvc.get("/api/city")
            .andDo { print() }
            .andExpect { status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$[0].startTime"){value("2022-08-12T12:00:00Z")}
            }


    }

    @Test
    fun`should return with coordinates values`(){
        val name = "sidney"
        mockMvc.get("api/city/$name")
            .andDo { print() }
            .andExpect { status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("startTime"){value("2022-08-12T12:00:00Z")}
            jsonPath("temperature"){value(19.69)}}
    }

    @Test
    fun`should return Not found if the name does not exist`(){
        val name = "does_not_exist"

        mockMvc.get("api/city/$name")
            .andDo { print() }
            .andExpect { status { isNotFound() } }


    }
}