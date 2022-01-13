package by.salei.admission.dao;

import by.salei.admission.dao.api.FacultyDao;
import by.salei.admission.entity.Faculty;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FacultyDaoImpl extends AbstractDao<Faculty> implements FacultyDao {
    @Override
    protected Class<Faculty> getEntityClass() {
        return Faculty.class;
    }

    @Override
    public List<Faculty> findAllByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Faculty> criteriaQuery = criteriaBuilder.createQuery(Faculty.class);
        Root<Faculty> root = criteriaQuery.from(Faculty.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("name"), getCriteriaLikeValue(name)));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
