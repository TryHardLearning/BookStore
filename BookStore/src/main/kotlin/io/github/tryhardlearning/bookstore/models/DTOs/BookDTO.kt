package io.github.tryhardlearning.bookstore.models.DTOs

class BookDTO(

    var id: Long?,

    var title: String,

    var description: String,

    var imageUrl: String,

    var author: AuthorDTO,
)