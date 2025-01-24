package io.github.tryhardlearning.bookstore.services.interfaces

import io.github.tryhardlearning.bookstore.models.Author

interface AuthorService {
    fun save(Author: Author): Author
}