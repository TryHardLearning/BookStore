package io.github.tryhardlearning.bookstore.services.implement

import io.github.tryhardlearning.bookstore.models.Author
import io.github.tryhardlearning.bookstore.repositories.AuthorRepository
import io.github.tryhardlearning.bookstore.services.interfaces.AuthorService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val repository: AuthorRepository) : AuthorService {

    override fun save(author: Author): Author {
        require(null == author.id)
        return repository.save(author)
    }

    override fun findAll(): List<Author> {
        return repository.findAll()
    }

    override fun findById(id: Long): Author {
        return repository.findById(id).orElse(null)
    }

    override fun delete(author: Author) {
        repository.delete(author)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    @Transactional
    override fun update(id: Long, author: Author): Author {
        check(repository.existsById(id))
        val safeAuthor = author.copy(id = id)
        return repository.save(safeAuthor)
    }
}