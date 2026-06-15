package se2034jv_thanhdhhe194260_carrentingsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CarProducer")
public class CarProducer {

    @Id
    @Column(name = "ProducerID")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer producerId;

    @Column(name = "ProducerName", columnDefinition = "Nvarchar(100)", nullable = false)
    @NotBlank(message = "Producer name is required")
    private String producerName;

    @Column(name = "Address", columnDefinition = "Nvarchar(255)", nullable = false)
    @NotBlank(message = "Address is required")
    private String address;

    @Column(name = "Country", columnDefinition = "Nvarchar(100)", nullable = false)
    @NotBlank(message = "Country is required")
    private String Country;
}
