package by.salei.admission.service;

import by.salei.admission.dao.api.SubjectDao;
import by.salei.admission.dto.SubjectCreateDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.dto.SubjectUpdateDto;
import by.salei.admission.entity.Subject;
import by.salei.admission.entity.SubjectType;
import by.salei.admission.service.api.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public SubjectCreateDto save(SubjectCreateDto entity) {

        subjectDao.save(Subject.builder()
                .type(SubjectType.valueOf(entity.getSubjectType()))
                .build());
        return entity;
    }

    @Override
    public SubjectUpdateDto update(SubjectUpdateDto newEntity) {
        return null;
    }

    @Override
    public SubjectGetDto delete(Long id) {
        return null;
    }

    @Override
    public SubjectGetDto getById(Long id) {

        Subject subject = subjectDao.getById(id);

        return SubjectGetDto
                .builder()
                .id(subject.getId())
                .subjectType(subject.getType().toString())
                .build();
    }

    @Override
    public List<SubjectGetDto> getAll() {
        return null;
    }
}
