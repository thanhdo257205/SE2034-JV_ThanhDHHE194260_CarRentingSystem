package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CarRentalId implements Serializable {

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "CarID")
    private Integer carId;

    @Column(name = "PickupDate")
    private LocalDateTime pickupDate;
}
