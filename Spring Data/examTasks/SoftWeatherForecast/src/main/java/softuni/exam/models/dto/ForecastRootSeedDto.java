package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastRootSeedDto {
    @XmlElement(name="forecast")
    private List<ForecastSeedDto> forecastSeedDtoList;

    public ForecastRootSeedDto() {
    }

    public List<ForecastSeedDto> getForecastSeedDtoList() {
        return forecastSeedDtoList;
    }

    public void setForecastSeedDtoList(List<ForecastSeedDto> forecastSeedDtoList) {
        this.forecastSeedDtoList = forecastSeedDtoList;
    }
}
