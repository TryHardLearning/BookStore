package io.github.tryhardlearning.bookstore.controllers

import io.github.tryhardlearning.bookstore.models.DTOs.BookDTO
import io.github.tryhardlearning.bookstore.services.interfaces.BookService
import io.github.tryhardlearning.bookstore.utils.extensions.toBook
import io.github.tryhardlearning.bookstore.utils.extensions.toBookDTO
import org.springframework.web.bind.annotation.RestController

@RestController("/books")
class BookController(private val service: BookService) {

    fun create(bookDTO: BookDTO): BookDTO {
        return service.save(bookDTO.toBook()).toBookDTO();
    }

}