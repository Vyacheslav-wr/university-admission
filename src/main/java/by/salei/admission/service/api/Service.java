package by.salei.admission.service.api;

import by.salei.admission.dto.AbstractCreateDto;
import by.salei.admission.dto.AbstractGetDto;
import by.salei.admission.dto.AbstractUpdateDto;

import java.util.List;

public interface Service<C extends AbstractCreateDto, G extends AbstractGetDto, U extends AbstractUpdateDto> {

    C save(C entity);

    U update(U newEntity);

    G delete(Long id);

    G getById(Long id);

    List<G> getAll();
}
