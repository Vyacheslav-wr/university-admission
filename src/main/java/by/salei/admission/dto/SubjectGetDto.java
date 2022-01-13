package by.salei.admission.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubjectGetDto extends AbstractGetDto {

    private Long id;
    private String subjectType;
}
