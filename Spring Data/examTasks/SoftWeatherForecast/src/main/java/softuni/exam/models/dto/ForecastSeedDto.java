package softuni.exam.models.dto;

import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.constants.DayOfWeek;

import java.time.LocalTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedDto {
    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;
    @XmlElement(name = "max_temperature")
    private Double maxTemperature;
    @XmlElement(name = "min_temperature")
    private Double minTemperature;
    @XmlElement
    private String sunrise;
    @XmlElement
    private String sunset;
    @XmlElement
    private Long city;

    public ForecastSeedDto() {
    }

    @NotNull
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Min(-20)
    @Max(60)
    @NotNull
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Min(-50)
    @Max(40)
    @NotNull
    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    @NotNull
    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @NotNull
    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
