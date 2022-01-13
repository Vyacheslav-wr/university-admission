package by.salei.admission.dto;

import lombok.Builder;

@Builder
public class EnrolleeCreateDto extends AbstractCreateDto {

    private String firstName;
    private String lastName;
    private Integer score;
    private Long user;
}
