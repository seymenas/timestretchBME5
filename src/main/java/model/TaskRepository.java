package model;

import model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class TaskRepository {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("timestretch-unit");

    public List<Task> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Task> tasks = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        em.close();
        return tasks;
    }

    public void save(Task task) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }
}
