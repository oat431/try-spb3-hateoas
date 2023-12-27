package panomete.playground.spb3hateoas.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Try HATEOAS with Spring Boot 3.2.0",
                version = "1.0.0",
                description = "Try HATEOAS with Spring Boot 3.2.0"
        )
)
public class OpenAPIConfig {
}
