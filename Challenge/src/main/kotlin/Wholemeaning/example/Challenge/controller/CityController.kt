package Wholemeaning.example.Challenge.controller

import Wholemeaning.example.Challenge.model.City
import Wholemeaning.example.Challenge.service.CityService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/cities")
class CityController(private val service: CityService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException):ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getCities(): Collection<City> = service.getCities()

    @GetMapping("/{name}")
    fun getCity(@PathVariable name: String):City = service.getCity(name)


}