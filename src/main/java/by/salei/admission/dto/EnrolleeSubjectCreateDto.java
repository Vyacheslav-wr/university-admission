package by.salei.admission.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EnrolleeSubjectCreateDto extends AbstractCreateDto {

    private Long subject_type_id;
    private Long enrollee_id;
    private Integer score;
}
