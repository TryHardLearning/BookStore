package io.github.tryhardlearning.bookstore.services.implement

import io.github.tryhardlearning.bookstore.models.Author
import io.github.tryhardlearning.bookstore.models.Book
import io.github.tryhardlearning.bookstore.repositories.BookRepository
import io.github.tryhardlearning.bookstore.services.interfaces.BookService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BookServiceImpl (private val repository: BookRepository) : BookService {
    override fun save(book: Book): Book {
        return repository.save(book)
    }
    override fun findAll(): List<Book> {
        return repository.findAll()
    }
    override fun findById(id: Long): Book {
        return repository.findById(id).orElse(null)
    }

    override fun delete(book: Book) {
        repository.delete(book)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    @Transactional
    override fun update(id: Long, book: Book): Book {
        check(repository.existsById(id))
        val safeAuthor = book.copy(id = id)
        return repository.save(safeAuthor)
    }
}