package io.github.tryhardlearning.bookstore.models

import jakarta.persistence.*


@Entity
@Table(name = "books")
data class Book(

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @Column(name = "id")
    var id: Long?,

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "imageURL")
    var imageUrl: String,

    @ManyToOne(cascade = [(CascadeType.DETACH)])
    @JoinTable(name = "author_id")
    var author: Author,
)