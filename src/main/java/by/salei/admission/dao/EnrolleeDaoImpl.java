package by.salei.admission.dao;

import by.salei.admission.dao.api.EnrolleeDao;
import by.salei.admission.entity.Enrollee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EnrolleeDaoImpl extends AbstractDao<Enrollee> implements EnrolleeDao {
    @Override
    protected Class<Enrollee> getEntityClass() {
        return Enrollee.class;
    }

    @Override
    public List<Enrollee> findAllByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Enrollee> criteriaQuery = criteriaBuilder.createQuery(Enrollee.class);
        Root<Enrollee> root = criteriaQuery.from(Enrollee.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("name"), getCriteriaLikeValue(name)));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
