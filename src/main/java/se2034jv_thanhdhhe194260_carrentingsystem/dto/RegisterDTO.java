package se2034jv_thanhdhhe194260_carrentingsystem.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Mobile is required")
    private String mobile;

    @NotNull(message = "Birthday is required")
    @Past(message = "Birthday must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "Identity card is required")
    private String identityCard;

    @NotBlank(message = "Licence number is required")
    private String licenceNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Licence date is required")
    private LocalDate licenceDate;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()]).+$", message = "The password must including uppercase letters, lowercase letters, numbers, and special characters")
    @Size(min = 8, message = "The password must have at least 8 characters.")
    private String password;

    @NotBlank(message = "Account Name is required")
    private String accountName;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;
}
