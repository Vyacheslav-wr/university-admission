package by.salei.admission.service;

import by.salei.admission.dto.SubjectCreateDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.dto.SubjectUpdateDto;
import by.salei.admission.service.api.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Override
    public SubjectCreateDto save(SubjectCreateDto entity) {
        return null;
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
        return null;
    }

    @Override
    public List<SubjectGetDto> getAll() {
        return null;
    }
}
