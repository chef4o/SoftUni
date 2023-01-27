package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedRootDto {

    @XmlElement(name="seller")
    private List<SellerSeedDto> sellers;

    public List<SellerSeedDto> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerSeedDto> sellers) {
        this.sellers = sellers;
    }
}
