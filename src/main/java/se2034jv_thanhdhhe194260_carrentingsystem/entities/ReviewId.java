package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReviewId {

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "CarId")
    private Integer carId;
}
