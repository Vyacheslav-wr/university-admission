package by.salei.admission.dao.api;

import by.salei.admission.entity.AbstractEntity;

import java.util.List;

public interface Dao<T extends AbstractEntity> {

    T save(T entity);

    T update(T newEntity);

    T delete(Long id);

    T getById(Long id);

    List<T> getAll();
}
