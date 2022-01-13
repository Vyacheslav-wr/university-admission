package by.salei.admission.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FacultyCreateDto extends AbstractCreateDto {

    private String Name;
    private Integer studentsSpots;
}
