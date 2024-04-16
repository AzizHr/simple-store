package org.aziz.springbootrestapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Simple Store API", version = "1.0", description = "Simple Store"))
public class SpringBootRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestapiApplication.class, args);
    }

}
