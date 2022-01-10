package by.salei.admission.dao.api;

import by.salei.admission.entity.Enrollee;

import java.util.List;

public interface EnrolleeDao extends Dao<Enrollee> {

    List<Enrollee> findAllByName(String name);
}
