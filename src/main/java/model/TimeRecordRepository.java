package model;

import model.TimeRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TimeRecordRepository {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("timestretch-unit");

    public void save(TimeRecord timeRecord) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(timeRecord);
        em.getTransaction().commit();
        em.close();
    }
}

