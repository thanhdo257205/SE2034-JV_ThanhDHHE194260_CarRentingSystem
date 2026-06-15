package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CarRental")
public class CarRental {

    @EmbeddedId
    private CarRentalId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", nullable = false)
    @MapsId("customerId")
    @NotNull(message = "Customer is required")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CarID", nullable = false)
    @MapsId("carId")
    @NotNull(message = "Car is required")
    private Car car;

    @Column(name = "ReturnDate", nullable = false)
    @NotNull(message = "Return date is required")
    private LocalDateTime returnDate;

    @Column(name = "RentPrice", nullable = false)
    @NotNull(message = "Rent price is required")
    @Positive(message = "Rent price must be greater than 0")
    private Double rentPrice;

    @Column(name = "Status", columnDefinition = "NVARCHAR(50)", nullable = false)
    @NotBlank(message = "Status is required")
    private String status;

}
