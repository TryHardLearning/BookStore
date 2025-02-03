package io.github.tryhardlearning.bookstore.services.interfaces

import io.github.tryhardlearning.bookstore.models.Book

interface BookService {
    fun save(book: Book): Book
    fun findAll(): List<Book>
    fun findById(id: Long): Book
    fun delete(book: Book)
    fun delete(id: Long)
    fun update(id: Long, book: Book): Book
}