package by.salei.admission.dao;

import by.salei.admission.dao.api.Dao;
import by.salei.admission.entity.AbstractEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Slf4j
public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {

    @Autowired
    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    public String getCriteriaLikeValue(String value) {
        return "%" + value.toLowerCase() + "%";
    }

    @Transactional
    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public T update(T newEntity) {
        entityManager.merge(newEntity);
        return newEntity;
    }

    @Transactional
    @Override
    public T delete(Long id) {
        entityManager.remove(entityManager.find(getEntityClass(), id));
        return null;
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> from = query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }
}
