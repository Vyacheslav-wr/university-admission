package by.salei.admission.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class UserGetDto extends AbstractGetDto {

    private Long id;
    private String username;
    private String password;
    private String role;
}
