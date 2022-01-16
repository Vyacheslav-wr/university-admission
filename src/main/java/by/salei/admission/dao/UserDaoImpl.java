package by.salei.admission.dao;

import by.salei.admission.dao.api.UserDao;
import by.salei.admission.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User getByUsername(String username) throws NoResultException {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), username));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
