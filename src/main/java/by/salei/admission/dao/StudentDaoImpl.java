package by.salei.admission.dao;

import by.salei.admission.dao.api.StudentDao;
import by.salei.admission.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl extends AbstractDao<Student> implements StudentDao {
    @Override
    protected Class<Student> getEntityClass() {
        return Student.class;
    }
}
