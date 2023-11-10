package pl.budowniczowie.apicar.car;

import org.springframework.stereotype.Service;
import pl.budowniczowie.apicar.exception.CarNotFoundException;

import java.util.List;
import java.util.Map;

@Service
public class CarService {

    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }
    List<Car> getAllCars() {
        return repository.findAll();
    }

    Car getCarById(Long id) {
        return (repository.findById(id).orElseThrow(() -> new CarNotFoundException(id)));
    }

    Car addCar(Car car) {
        return repository.save(car);
    }

    List<Car> getCarByColor(String color) {
        return repository.findByColor(color);
    }

    void deleteCar(Long id) {
        repository.deleteById(id);
    }

    Car updateCar(Long id, Car car) {
        Car carToUpdate = repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setColor(car.getColor());
        return repository.save(carToUpdate);
    }

    Car updateCarPatch(Long id, Map<String, Object> patch) {
        return repository.findById(id).map(car -> {
            if (patch.get("brand") != null) {
                car.setBrand((String) patch.get("brand"));
            }
            if (patch.get("model") != null) {
                car.setModel((String) patch.get("model"));
            }
            if (patch.get("color") != null) {
                car.setColor((String) patch.get("color"));
            }
            return repository.save(car);
        }).orElseThrow(() -> new CarNotFoundException(id));
    }
}
