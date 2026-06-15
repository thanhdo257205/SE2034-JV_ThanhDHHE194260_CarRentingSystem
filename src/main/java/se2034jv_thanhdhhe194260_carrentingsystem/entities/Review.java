package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Review")
public class Review {

    @Embedded
    private ReviewId id;

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

    @Column(name = "ReviewStar", nullable = false)
    @NotNull(message = "Review star is required")
    @Min(value = 1, message = "Review star must be at least 1")
    @Max(value = 5, message = "Review star must not exceed 5")
    private Integer reviewStar;

    @Column(name = "Comment", columnDefinition = "NVARCHAR(1000)", nullable = false)
    @NotBlank(message = "Comment is required")
    private String comment;

}
