package pl.budowniczowie.apicar.car;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(
        value = "/api/v1/car",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
@Tag(name = "Car", description = "Car API")

public class CarController {

    private final CarService  service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("")
    public CollectionModel<Car> getAllCars() {
        List<Car> cars = service.getAllCars();
        cars.stream().forEach(car -> {
            Link link = linkTo(CarController.class).slash(car.getId()).withSelfRel();
            car.add(link);
        });
        Link link = linkTo(CarController.class).withSelfRel();
        return CollectionModel.of(cars, link);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Link link = linkTo(methodOn(CarController.class).getCarById(id)).withSelfRel();
        Car car = service.getCarById(id);
        car.add(link);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/")
    public ResponseEntity<List<Car>> getCarByColor(@RequestParam String color) {
        List<Car> cars = service.getCarByColor(color);
        cars.stream().forEach(car -> {
            Link link = linkTo(methodOn(CarController.class).getCarById(car.getId())).withSelfRel();
            car.add(link);
        });
        return ResponseEntity.ok(cars);
    }

    @PostMapping("")
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
        return ResponseEntity.accepted().body(service.addCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car car) {
        return ResponseEntity.ok(service.updateCar(id, car));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> updateCarPatch(@PathVariable("id") Long id, @RequestBody Map<String, Object> patch) {
        return ResponseEntity.ok(service.updateCarPatch(id, patch));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
        service.deleteCar(id);
        return ResponseEntity.status(204).build();
    }
}
