package io.github.tryhardlearning.bookstore.controllers

import io.github.tryhardlearning.bookstore.models.Book
import io.github.tryhardlearning.bookstore.models.DTOs.BookDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/authors")
class AuthorController {

    @PostMapping
    fun create(@RequestBody book: BookDTO): BookDTO {
        return book
    }

}

/// Video in 1:45:36