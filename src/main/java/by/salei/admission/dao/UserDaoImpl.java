package by.salei.admission.dao;

import by.salei.admission.dao.api.UserDao;
import by.salei.admission.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
