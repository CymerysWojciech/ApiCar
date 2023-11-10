package pl.budowniczowie.apicar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "ApiCar",
                version = "1.0.0",
                description = "ApiCar",
                contact = @Contact(
                        name = "Wojciech Cymerys",
                        email = "wojciech.cymerys@onet.pl"
                )
        )
)


@SpringBootApplication
public class ApiCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCarApplication.class, args);
    }




}
