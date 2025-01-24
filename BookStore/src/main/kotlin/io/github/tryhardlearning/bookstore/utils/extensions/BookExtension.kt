package io.github.tryhardlearning.bookstore.utils.extensions

import io.github.tryhardlearning.bookstore.models.Book
import io.github.tryhardlearning.bookstore.models.DTOs.BookDTO

fun Book.toBookDTO(): BookDTO {
    return BookDTO(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl,
        author = this.author.toAuthorDTO()
    )
}
fun BookDTO.toBook(): Book {
    return Book(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl,
        author = this.author.toAuthor()
    )
}