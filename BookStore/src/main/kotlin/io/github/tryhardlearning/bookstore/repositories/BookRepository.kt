package io.github.tryhardlearning.bookstore.repositories

import io.github.tryhardlearning.bookstore.models.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}