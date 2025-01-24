package io.github.tryhardlearning.bookstore.utils.extensions

import io.github.tryhardlearning.bookstore.models.Author
import io.github.tryhardlearning.bookstore.models.DTOs.AuthorDTO

fun Author.toAuthorDTO(): AuthorDTO {
    return AuthorDTO(
        id = this.id,
        name = this.name,
        email = this.email,
        age = this.age,
        description = this.description,
        imageURL = this.imageURL
    )
}
fun AuthorDTO.toAuthor(): Author {
    return Author(
        id = this.id,
        name = this.name,
        email = this.email,
        age = this.age,
        description = this.description,
        imageURL = this.imageURL
    )
}