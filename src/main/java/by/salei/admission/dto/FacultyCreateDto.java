package by.salei.admission.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class FacultyCreateDto extends AbstractCreateDto {

    private String name;
    private Integer studentsSpots;
    private String subject0;
    private String subject1;
    private String subject2;
}
