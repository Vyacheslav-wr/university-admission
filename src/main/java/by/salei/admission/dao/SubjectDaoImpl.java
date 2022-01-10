package by.salei.admission.dao;

import by.salei.admission.dao.api.SubjectDao;
import by.salei.admission.entity.Subject;

public class SubjectDaoImpl extends AbstractDao<Subject> implements SubjectDao {
    @Override
    protected Class<Subject> getEntityClass() {
        return Subject.class;
    }
}