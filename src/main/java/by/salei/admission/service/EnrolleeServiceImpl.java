package by.salei.admission.service;

import by.salei.admission.dao.api.EnrolleeDao;
import by.salei.admission.dao.api.FacultyDao;
import by.salei.admission.dao.api.UserDao;
import by.salei.admission.dto.EnrolleeCreateDto;
import by.salei.admission.dto.EnrolleeGetDto;
import by.salei.admission.dto.EnrolleeUpdateDto;
import by.salei.admission.entity.Enrollee;
import by.salei.admission.entity.EnrolleeStatus;
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
        enrollee.setStatus(EnrolleeStatus.REGISTERED);

        enrolleeDao.save(enrollee);

        return entity;
    }

    @Override
    public EnrolleeUpdateDto update(EnrolleeUpdateDto newEntity) {

        Enrollee enrollee = new Enrollee();

        enrollee.setId(newEntity.getId());
        enrollee.setFirstName(newEntity.getFirstName());
        enrollee.setLastName(newEntity.getLastName());
        enrollee.setEmail(newEntity.getEmail());
        enrollee.setScore(newEntity.getScore());
        enrollee.setStatus(EnrolleeStatus.valueOf(newEntity.getStatus()));
        enrollee.setStatus(EnrolleeStatus.valueOf(newEntity.getStatus()));

        enrolleeDao.update(enrollee);

        return newEntity;
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
                .status(enrollee.getStatus().toString())
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
                                        .lastName(entity.getLastName())
                                        .score(entity.getScore())
                                        .user_id(entity.getUser().getId())
                                        .status(entity.getStatus().toString())
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

    //@Transactional
    @Override
    public void setFaculty(Long faculty_id, Long enrollee_id) {
        Faculty faculty = facultyDao.getById(faculty_id);

        Enrollee enrollee = enrolleeDao.getById(enrollee_id);

        enrollee.setFaculty(faculty);
    }

    //@Transactional
    @Override
    public void setStatus(Long id, String status) {

        Enrollee enrollee = enrolleeDao.getById(id);
        enrollee.setStatus(EnrolleeStatus.valueOf(status));
        enrolleeDao.update(enrollee);
    }

}
