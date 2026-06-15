package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "CustomerName", nullable = false, length = 100)
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Column(name = "Mobile", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Mobile is required")
    private String mobile;

    @Column(name = "Birthday", nullable = false)
    @NotNull(message = "Birthday is required")
    @Past(message = "Birthday must be in the past")
    private LocalDate birthday;

    @Column(name = "IdentityCard", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Identity card is required")
    private String identityCard;

    @Column(name = "LicenceNumber", nullable = false, unique = true, length = 50)
    @NotBlank(message = "Licence number is required")
    private String licenceNumber;

    @Column(name = "LicenceDate", nullable = false)
    @NotNull(message = "Licence date is required")
    private LocalDate licenceDate;

    @Column(name = "Email", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "Password", nullable = false, length = 255)
    @NotBlank(message = "Password is required")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AccountID", nullable = false)
    @NotNull(message = "Account is required")
    private Account account;

}
