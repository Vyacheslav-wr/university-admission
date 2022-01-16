package by.salei.admission.dao;

import by.salei.admission.dao.api.EnrolleeSubjectDao;
import by.salei.admission.entity.EnrolleeSubject;
import org.springframework.stereotype.Repository;

@Repository
public class EnrolleeSubjectDaoImpl extends AbstractDao<EnrolleeSubject> implements EnrolleeSubjectDao {
    @Override
    protected Class<EnrolleeSubject> getEntityClass() {
        return EnrolleeSubject.class;
    }
}
