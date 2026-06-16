package se2034jv_thanhdhhe194260_carrentingsystem.dto;

import lombok.*;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Role;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    private Integer id;
    private String username;
    private String customerName;
    private String email;
    private Role role;
    private String mobile;
    private LocalDateTime birthday;
    private String identityCard;
    private String licenceNumber;
    private LocalDateTime licenceDate;
}
