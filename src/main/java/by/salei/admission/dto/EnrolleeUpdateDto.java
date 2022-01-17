package by.salei.admission.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class EnrolleeUpdateDto extends AbstractUpdateDto {

    private Long id;
    private String FirstName;
    private String lastName;
    private Integer score;
    private String email;
    private String status;

}
