package ru.testprojects.crudrtcomm.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testprojects.crudrtcomm.model.ToDo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ToDoRepositoryImpl implements ToDoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ToDo get(int id) {
        return em.find(ToDo.class, id);
    }

    @Override
    public List<ToDo> getAll() {
        return em.createQuery("SELECT t FROM ToDo t ORDER BY t.startDate, t.description").getResultList();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createQuery("DELETE FROM ToDo t WHERE t.id=:id").setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    @Transactional
    public ToDo save(ToDo toDo) {
        if (toDo.isNew()) {
            em.persist(toDo);
            return toDo;
        } else {
            return em.merge(toDo);
        }
    }

}
