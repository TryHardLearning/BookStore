package io.github.tryhardlearning.bookstore.controllers

import io.github.tryhardlearning.bookstore.models.DTOs.AuthorDTO
import io.github.tryhardlearning.bookstore.services.interfaces.AuthorService
import io.github.tryhardlearning.bookstore.utils.extensions.toAuthor
import io.github.tryhardlearning.bookstore.utils.extensions.toAuthorDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/authors")
class AuthorController(private val service: AuthorService) {

    @PostMapping
    fun create(@RequestBody authorDTO: AuthorDTO): AuthorDTO {
        return service.save(authorDTO.toAuthor()).toAuthorDTO();
    }

}

/// Video in 2:00:46