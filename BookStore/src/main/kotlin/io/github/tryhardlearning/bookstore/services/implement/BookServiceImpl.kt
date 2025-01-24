package io.github.tryhardlearning.bookstore.services.implement

import io.github.tryhardlearning.bookstore.models.Book
import io.github.tryhardlearning.bookstore.services.interfaces.BookService
import org.springframework.stereotype.Service

@Service
class BookServiceImpl (private val service: BookService) : BookService {
    override fun save(book: Book): Book {
        return service.save(book)
    }
}