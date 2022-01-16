package by.salei.admission.service;

import by.salei.admission.dao.api.EnrolleeDao;
import by.salei.admission.dao.api.FacultyDao;
import by.salei.admission.dao.api.UserDao;
import by.salei.admission.dto.EnrolleeCreateDto;
import by.salei.admission.dto.EnrolleeGetDto;
import by.salei.admission.dto.EnrolleeUpdateDto;
import by.salei.admission.entity.Enrollee;
import by.salei.admission.entity.Faculty;
import by.salei.admission.service.api.EnrolleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EnrolleeServiceImpl implements EnrolleeService {

    @Autowired
    EnrolleeDao enrolleeDao;

    @Autowired
    UserDao userDao;

    @Autowired
    FacultyDao facultyDao;

    @Override
    public EnrolleeCreateDto save(EnrolleeCreateDto entity) {

        Enrollee enrollee = new Enrollee();
        enrollee.setFirstName(entity.getFirstName());
        enrollee.setLastName(entity.getLastName());
        enrollee.setEmail(entity.getEmail());
        enrollee.setScore(entity.getScore());
        enrollee.setUser(userDao.getById(entity.getUser()));

        enrolleeDao.save(enrollee);

        return entity;
    }

    @Override
    public EnrolleeUpdateDto update(EnrolleeUpdateDto newEntity) {


        return null;
    }

    @Override
    public EnrolleeGetDto delete(Long id) {
        return null;
    }

    @Override
    public EnrolleeGetDto getById(Long id) {

        Enrollee enrollee = enrolleeDao.getById(id);

        return EnrolleeGetDto.builder()
                .id(enrollee.getId())
                .firstName(enrollee.getFirstName())
                .lastName(enrollee.getLastName())
                .score(enrollee.getScore())
                .user_id(enrollee.getUser().getId())
                .build();
    }

    @Override
    public List<EnrolleeGetDto> getAll() {

        return enrolleeDao.getAll()
                .stream().
                        map(entity ->
                                EnrolleeGetDto
                                        .builder()
                                        .id(entity.getId())
                                        .firstName(entity.getFirstName())
                                        .lastName(entity.getFirstName())
                                        .score(entity.getScore())
                                        .user_id(entity.getUser().getId())
                                        .build()
                        ).collect(Collectors.toList());
    }

    @Override
    public EnrolleeGetDto findByUserId(Long id) {

        return this.getAll().stream()
                .filter(entity -> entity.getUser_id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean isAlreadyRegistered(Long id) {
        return enrolleeDao.getById(id).getFaculty() != null;
    }

    @Override
    public void setFaculty(Long faculty_id, Long enrollee_id) {
        Faculty faculty = facultyDao.getById(faculty_id);

        Enrollee enrollee = enrolleeDao.getById(enrollee_id);

        enrollee.setFaculty(faculty);
    }

}
