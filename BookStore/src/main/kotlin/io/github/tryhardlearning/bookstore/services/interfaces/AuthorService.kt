package io.github.tryhardlearning.bookstore.services.interfaces

import io.github.tryhardlearning.bookstore.models.Author

interface AuthorService {
    fun save(author: Author): Author
    fun findAll(): List<Author>
    fun findById(id: Long): Author
    fun delete(author: Author)
    fun delete(id: Long)
    fun update(id: Long ,author: Author): Author
}