package by.salei.admission.dao;

import by.salei.admission.dao.api.SubjectDao;
import by.salei.admission.entity.Faculty;
import by.salei.admission.entity.Subject;
import by.salei.admission.entity.SubjectType;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class SubjectDaoImpl extends AbstractDao<Subject> implements SubjectDao {
    @Override
    protected Class<Subject> getEntityClass() {
        return Subject.class;
    }

    @Override
    public Subject findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
        Root<Subject> root = criteriaQuery.from(Subject.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("type"), SubjectType.valueOf(name)));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
