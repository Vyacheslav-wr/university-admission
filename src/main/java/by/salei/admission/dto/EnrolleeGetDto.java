package by.salei.admission.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class EnrolleeGetDto extends AbstractGetDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer score;
    private Long user_id;
    private Integer generalScore;
    private String status;
}
