package ru.itmo.database.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_authors")
public class Author extends Unique {
    @Column(nullable = false, length = 200)
    private String fullName;

    @ManyToMany( /* mappedBy - с другой стороны от JoinTable*/ )
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private ArrayList<Book> books;
}
