package io.github.tryhardlearning.bookstore.controllers

import io.github.tryhardlearning.bookstore.models.DTOs.BookDTO
import io.github.tryhardlearning.bookstore.services.interfaces.BookService
import io.github.tryhardlearning.bookstore.utils.extensions.toBook
import io.github.tryhardlearning.bookstore.utils.extensions.toBookDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/books")
class BookController(private val service: BookService) {

    @PostMapping
    fun create(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> {
        try {
            val author = service.save(bookDTO.toBook()).toBookDTO();
            return ResponseEntity(author, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<BookDTO>> {
        val authors = service.findAll().map { it.toBookDTO() }
        if (authors.isNotEmpty()) {
            return ResponseEntity(authors, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping(path = ["/{id}"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<BookDTO> {
        try {
            val author = service.findById(id).toBookDTO()
            return ResponseEntity(author, HttpStatus.OK)
        }catch (e: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @PutMapping
    fun update(@PathVariable("id") id: Long, @RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> {
        try {
            val author = service.update(id,bookDTO.toBook()).toBookDTO()
            return ResponseEntity(author, HttpStatus.OK)
        }catch (e: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
    @DeleteMapping
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        try {
            service.delete(id)
            return ResponseEntity(HttpStatus.OK)
        }catch (e: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

}