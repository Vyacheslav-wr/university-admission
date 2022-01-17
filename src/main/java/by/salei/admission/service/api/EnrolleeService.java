package by.salei.admission.service.api;

import by.salei.admission.dto.EnrolleeCreateDto;
import by.salei.admission.dto.EnrolleeGetDto;
import by.salei.admission.dto.EnrolleeUpdateDto;
import by.salei.admission.dto.UserGetDto;

public interface EnrolleeService extends Service<EnrolleeCreateDto, EnrolleeGetDto, EnrolleeUpdateDto>{

    EnrolleeGetDto findByUserId(Long id);

    Boolean isAlreadyRegistered(Long id);

    void setFaculty(Long faculty_id, Long enrollee_id);

    void setStatus(Long id, String status);
}
