package zerobase.weather.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI(@Value("${springdoc.version}") String version) {
    Info info = new Info().title("Demo API").version(version)
      .description("Spring Boot를 이용한 Demo 웹 애플리케이션 API입니다.")
      .contact(new Contact().name("Goo99").url("https://github.com/JGoo99")
        .email("465112jin@gamil.com"))
      ;

    return new OpenAPI()
      .components(new Components())
      .info(info);
  }
}
