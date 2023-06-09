package ru.itmo.database.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.database.jpa.dao.LibraryUserDAO;
import ru.itmo.database.jpa.entity.City;
import ru.itmo.database.jpa.entity.LibraryUser;
import ru.itmo.database.jpa.entity.PublishingHouse;
import ru.itmo.database.jpa.entity.PublishingPrimaryKey;

public class JPA {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
             EntityManager manager = emf.createEntityManager()) {

            PublishingPrimaryKey publishingKey01 = new PublishingPrimaryKey("Pub.House #1", City.PSKOV);
            PublishingHouse house = new PublishingHouse(publishingKey01);

            LibraryUser libraryUser01 = new LibraryUser("uu0000001", "Карпатов А. Ю.", "+79991112233", "СПБ");

            manager.getTransaction().begin();
            manager.persist(house);
            manager.persist(libraryUser01);
            manager.getTransaction().commit();

            System.out.println(manager.find(PublishingHouse.class, publishingKey01).getCity());
            System.out.println(manager.find(LibraryUser.class, "uu0000001").getFullName());

            libraryUser01.setPhone("+79995551111");

            manager.getTransaction().begin();
            manager.merge(libraryUser01);
            manager.getTransaction().commit();

            System.out.println(manager.find(LibraryUser.class, "uu0000001").getPhone());

            manager.getTransaction().begin();
            manager.remove(house);
            manager.getTransaction().commit();

            System.out.println(manager.find(LibraryUser.class, "uu0000001"));

            LibraryUserDAO libraryUserDAO = new LibraryUserDAO(manager);
            System.out.println(libraryUserDAO.selectAll());
        }

    }
}
