package pl.budowniczowie.apicar.car;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Data
public class Car extends RepresentationModel<Car> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Brand cannot be null")
    @Size(min = 2, max = 20, message = "Brand must be between 2 and 20 characters")
    private String brand;
    @NotNull(message = "Model cannot be null")
    @Size(min = 2, max = 20, message = "Model must be between 2 and 20 characters")
    private String model;
    @NotNull(message = "Color cannot be null")
    @Size(min = 2, max = 20, message = "Color must be between 2 and 20 characters")
    private String color;

    public Car() {
    }
    @JsonCreator
    public Car(Long id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

}
