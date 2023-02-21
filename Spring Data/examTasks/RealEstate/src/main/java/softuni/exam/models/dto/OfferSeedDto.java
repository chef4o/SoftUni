package softuni.exam.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {
    @XmlElement
    private BigDecimal price;
    @XmlElement
    private String publishedOn;
    @XmlElement
    private OfferAgentSeedDto agent;
    @XmlElement
    private OfferApartmentSeedDto apartment;

    @NotNull
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotBlank
    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    @NotNull
    public OfferAgentSeedDto getAgent() {
        return agent;
    }

    public void setAgent(OfferAgentSeedDto agent) {
        this.agent = agent;
    }

    @NotNull
    public OfferApartmentSeedDto getApartment() {
        return apartment;
    }

    public void setApartment(OfferApartmentSeedDto apartment) {
        this.apartment = apartment;
    }
}
