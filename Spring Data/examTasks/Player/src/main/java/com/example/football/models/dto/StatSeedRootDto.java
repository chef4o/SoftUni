package com.example.football.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatSeedRootDto {

    @XmlElement(name="stat")
    private List<StatSeedDto> statSeedDtoList;

    public StatSeedRootDto() {
    }

    public List<StatSeedDto> getStatSeedDtoList() {
        return statSeedDtoList;
    }

    public void setStatSeedDtoList(List<StatSeedDto> statSeedDtoList) {
        this.statSeedDtoList = statSeedDtoList;
    }
}
