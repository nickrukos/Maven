package ru.itmo.database.jpa.dao;

import jakarta.persistence.EntityManager;
import ru.itmo.database.jpa.entity.Book;


public class BookDao extends AbstractDao<Book, String>{

    public BookDao(EntityManager entityManager, Class<Book> clazz) {
        super(entityManager, clazz);
    }
}
