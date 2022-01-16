package by.salei.admission.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectCreateDto extends AbstractCreateDto {

    private String subjectType;
}
