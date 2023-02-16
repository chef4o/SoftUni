package exam.model.dto;

import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name="towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownSeedRootDto {
    @XmlElement(name="town")
    private Set<TownSeedDto> townSeedDtoSet;

    public TownSeedRootDto() {
    }

    public Set<TownSeedDto> getTownSeedDtoSet() {
        return townSeedDtoSet;
    }

    public void setTownSeedDtoSet(Set<TownSeedDto> townSeedDtoSet) {
        this.townSeedDtoSet = townSeedDtoSet;
    }
}
