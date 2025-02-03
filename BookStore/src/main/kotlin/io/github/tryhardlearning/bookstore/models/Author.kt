package io.github.tryhardlearning.bookstore.models

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @Column(name = "id")
    var id: Long?,

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "age")
    var age: Int,

    @Column(name = "description")
    var description: String,

    @Column(name = "imageURL")
    var imageURL: String
)