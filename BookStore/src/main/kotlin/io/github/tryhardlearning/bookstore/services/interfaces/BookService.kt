package io.github.tryhardlearning.bookstore.services.interfaces

import io.github.tryhardlearning.bookstore.models.Book

interface BookService {
    fun save(book: Book): Book
}