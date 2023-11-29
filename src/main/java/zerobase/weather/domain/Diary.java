package zerobase.weather.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Schema(description = "Diary DB update request")
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "diary id", example = "1")
  private int id;

  @Schema(description = "weather", example = "Snow")
  private String weather;

  @Schema(description = "icon", example = "01n")
  private String icon;

  @Schema(description = "temperature", example = "271.56")
  private double temperature;

  @Schema(description = "diary text", example = "오늘은 마라탕을 먹었다.")
  private String text;

  @Schema(description = "diary creation date", example = "2023-11-30")
  private LocalDate date;

  @Schema(description = "weather data to diary weather", implementation = DateWeather.class)
  public void setDateWeather(DateWeather dateWeather) {
    this.weather = dateWeather.getWeather();
    this.icon = dateWeather.getIcon();
    this.temperature = dateWeather.getTemperature();
    this.date = dateWeather.getDate();
  }
}
