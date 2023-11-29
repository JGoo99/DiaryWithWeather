package zerobase.weather.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "date_weather")
@NoArgsConstructor
@Schema(description = "Weather DB update request")
public class DateWeather {

  @Id
  @Schema(description = "weather generation date", example = "2023-11-30")
  private LocalDate date;

  @Schema(description = "weather", example = "Snow")
  private String weather;

  @Schema(description = "icon", example = "01n")
  private String icon;

  @Schema(description = "temperature", example = "271.56")
  private double temperature;
}
