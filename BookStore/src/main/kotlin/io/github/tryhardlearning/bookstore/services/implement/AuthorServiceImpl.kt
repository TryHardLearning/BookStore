package io.github.tryhardlearning.bookstore.services.implement

import io.github.tryhardlearning.bookstore.models.Author
import io.github.tryhardlearning.bookstore.repositories.AuthorRepository
import io.github.tryhardlearning.bookstore.services.interfaces.AuthorService
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val repository: AuthorRepository) : AuthorService {

    override fun save(author: Author): Author {
        return repository.save(author)
    }
}