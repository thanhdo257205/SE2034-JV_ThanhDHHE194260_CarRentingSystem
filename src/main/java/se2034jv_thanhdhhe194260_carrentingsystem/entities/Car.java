package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @Column(name = "CarID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;

    @Column(name = "CarName", columnDefinition = "Nvarchar(100)", nullable = false)
    @NotBlank(message = "Car name is required")
    private String carName;

    @Column(name = "CarModelYear", nullable = false)
    @NotNull(message = "Car model year is required")
    private Integer carModelYear;

    @Column(name = "Color", columnDefinition = "Nvarchar(50)", nullable = false)
    @NotBlank(message = "Color is required")
    private String color;

    @Column(name = "Capacity", nullable = false)
    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @Column(name = "Description",  nullable = false, columnDefinition = "Nvarchar(1000)")
    @NotBlank(message = "Description is required")
    private String description;

    @Column(name = "ImportDate", columnDefinition = "Date", nullable = false)
    @NotNull(message = "Import date is required")
    private LocalDate importDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProducerID", nullable = false)
    @NotNull(message = "Producer is required")
    private CarProducer carProducer;

    @Column(name = "RentPrice", columnDefinition = "Decimal(18, 2)", nullable = false)
    @NotNull(message = "Rent price is required")
    private Double rentPrice;

    @Column(name = "Status", columnDefinition = "Nvarchar(50)", nullable = false)
    @NotBlank(message = "Status is required")
    private String status;

}
