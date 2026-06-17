package se2034jv_thanhdhhe194260_carrentingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.CarProducer;

import java.util.List;

public interface CarProducerRepo extends JpaRepository<CarProducer,Integer> {

    @Query("""
        SELECT cp FROM CarProducer cp WHERE lower(cp.producerName) LIKE lower(concat('%', :keyword, '%')) or lower(cp.Country) = lower(:keyword) or lower(cp.address) = lower(:keyword) 
""")
    List<CarProducer> findByNameOrCountry(@Param("keyword") String keyword);

    void removeByProducerId(Integer producerId);

    void deleteCarProducerByProducerId(Integer producerId);
}
