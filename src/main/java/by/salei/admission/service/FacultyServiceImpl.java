package by.salei.admission.service;

import by.salei.admission.dao.api.FacultyDao;
import by.salei.admission.dto.FacultyCreateDto;
import by.salei.admission.dto.FacultyGetDto;
import by.salei.admission.dto.FacultyUpdateDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.entity.Faculty;
import by.salei.admission.service.api.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Override
    public FacultyCreateDto save(FacultyCreateDto entity) {

        Faculty faculty = new Faculty();
        faculty.setName(entity.getName());
        faculty.setStudentsSpots(entity.getStudentsSpots());
        facultyDao.save(faculty);
        return entity;
    }

    @Override
    public FacultyUpdateDto update(FacultyUpdateDto newEntity) {
        return null;
    }

    @Override
    public FacultyGetDto delete(Long id) {
        return null;
    }

    @Override
    public FacultyGetDto getById(Long id) {

        Faculty faculty = facultyDao.getById(id);

        return FacultyGetDto
                .builder()
                    .id(faculty.getId())
                    .subjects(faculty.getSubjects()
                            .stream()
                            .map(subject -> SubjectGetDto
                                    .builder()
                                    .id(subject.getId())
                                    .subjectType(subject.getType().toString())
                                    .build())
                            .collect(Collectors.toList()))
                    .name(faculty.getName())
                    .studentsSpots(faculty.getStudentsSpots())
                .build();
    }

    @Override
    public List<FacultyGetDto> getAll() {

        return facultyDao.getAll()
                .stream()
                .map(entity -> FacultyGetDto
                        .builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .studentsSpots(entity.getStudentsSpots())
                        .build())
                .collect(Collectors.toList());
    }
}
