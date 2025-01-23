package io.github.tryhardlearning.bookstore.repositories

import io.github.tryhardlearning.bookstore.models.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
}