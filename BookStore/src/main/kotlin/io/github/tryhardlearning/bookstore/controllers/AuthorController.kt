package io.github.tryhardlearning.bookstore.controllers

import io.github.tryhardlearning.bookstore.models.DTOs.AuthorDTO
import io.github.tryhardlearning.bookstore.services.interfaces.AuthorService
import io.github.tryhardlearning.bookstore.utils.extensions.toAuthor
import io.github.tryhardlearning.bookstore.utils.extensions.toAuthorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/authors")
class AuthorController(private val service: AuthorService) {

    @PostMapping
    fun create(@RequestBody authorDTO: AuthorDTO): ResponseEntity<AuthorDTO> {
        try {
            val author = service.save(authorDTO.toAuthor()).toAuthorDTO();
            return ResponseEntity(author, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<AuthorDTO>> {
        val authors = service.findAll().map { it.toAuthorDTO() }
        if (authors.isNotEmpty()) {
            return ResponseEntity(authors, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping(path = ["/{id}"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<AuthorDTO> {
        try {
            val author = service.findById(id).toAuthorDTO()
            return ResponseEntity(author, HttpStatus.OK)
        }catch (e: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @PutMapping
    fun update(@PathVariable("id") id: Long, @RequestBody authorDTO: AuthorDTO): ResponseEntity<AuthorDTO> {
        try {
            val author = service.update(id,authorDTO.toAuthor()).toAuthorDTO();
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
/// Testes Video in 2:00:46