package by.salei.admission.dao.api;

import by.salei.admission.entity.Faculty;

import java.util.List;

public interface FacultyDao extends Dao<Faculty> {

    List<Faculty> findAllByName(String name);
}
