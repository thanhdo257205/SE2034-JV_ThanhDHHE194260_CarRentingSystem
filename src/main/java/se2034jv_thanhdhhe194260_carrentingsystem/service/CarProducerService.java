package se2034jv_thanhdhhe194260_carrentingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.CarProducer;
import se2034jv_thanhdhhe194260_carrentingsystem.repository.CarProducerRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarProducerService {

    private final CarProducerRepo carProducerRepo;

    public void saveCarProducer(CarProducer carProducer){
        carProducerRepo.save(carProducer);
    }

    public List<CarProducer> findAllCarProducer(){
        return carProducerRepo.findAll();
    }

    public List<CarProducer> findByNameOrCountry(String keyword) {
        return carProducerRepo.findByNameOrCountry(keyword);
    }

    @Transactional
    public void removeCarProducer(Integer producerId){
        carProducerRepo.deleteCarProducerByProducerId(producerId);
    }
}
