package peaksoft.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnection {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peaksoft");

   public static EntityManager  createEntityManager(){
        return entityManagerFactory.createEntityManager();
   }
}
