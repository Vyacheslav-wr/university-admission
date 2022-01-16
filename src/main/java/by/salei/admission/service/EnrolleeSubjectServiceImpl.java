package by.salei.admission.service;

import by.salei.admission.dao.api.EnrolleeDao;
import by.salei.admission.dao.api.EnrolleeSubjectDao;
import by.salei.admission.dao.api.SubjectDao;
import by.salei.admission.dto.EnrolleeSubjectCreateDto;
import by.salei.admission.dto.EnrolleeSubjectGetDto;
import by.salei.admission.dto.EnrolleeSubjectUpdateDto;
import by.salei.admission.entity.EnrolleeSubject;
import by.salei.admission.service.api.EnrolleeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrolleeSubjectServiceImpl implements EnrolleeSubjectService {

    @Autowired
    private EnrolleeSubjectDao enrolleeSubjectDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private EnrolleeDao enrolleeDao;

    @Override
    public EnrolleeSubjectCreateDto save(EnrolleeSubjectCreateDto entity) {

        enrolleeSubjectDao.save(EnrolleeSubject.builder()
                .subject_type(subjectDao.getById(entity.getSubject_type_id()))
                .score(entity.getScore())
                .enrollee(enrolleeDao.getById(entity.getEnrollee_id()))
                .build());
        return entity;
    }

    @Override
    public EnrolleeSubjectUpdateDto update(EnrolleeSubjectUpdateDto newEntity) {
        return null;
    }

    @Override
    public EnrolleeSubjectGetDto delete(Long id) {
        return null;
    }

    @Override
    public EnrolleeSubjectGetDto getById(Long id) {
        return null;
    }

    @Override
    public List<EnrolleeSubjectGetDto> getAll() {
        return null;
    }
}
