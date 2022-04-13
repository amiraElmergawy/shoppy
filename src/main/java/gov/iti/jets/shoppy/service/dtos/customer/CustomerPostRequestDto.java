package gov.iti.jets.shoppy.service.dtos.customer;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomerPostRequestDto {
    private String username;
    private String email;
    private String password;
    private String interests;
    private boolean isMale;
    private String dateOfBirth;

}
