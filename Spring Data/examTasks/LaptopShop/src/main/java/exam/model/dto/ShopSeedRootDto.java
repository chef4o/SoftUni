package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedRootDto {
    @XmlElement(name = "shop")
    private Set<ShopSeedDto> shopSeedDtoSet;

    public ShopSeedRootDto() {
    }

    public Set<ShopSeedDto> getShopSeedDtoSet() {
        return shopSeedDtoSet;
    }

    public void setShopSeedDtoSet(Set<ShopSeedDto> shopSeedDtoSet) {
        this.shopSeedDtoSet = shopSeedDtoSet;
    }
}
