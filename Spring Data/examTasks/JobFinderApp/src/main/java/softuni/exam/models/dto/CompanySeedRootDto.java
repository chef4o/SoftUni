package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanySeedRootDto {
    @XmlElement(name = "company")
    private List<CompanySeedDto> companySeedDtoList;

    public List<CompanySeedDto> getCompanySeedDtoList() {
        return companySeedDtoList;
    }

    public void setCompanySeedDtoList(List<CompanySeedDto> companySeedDtoList) {
        this.companySeedDtoList = companySeedDtoList;
    }
}
