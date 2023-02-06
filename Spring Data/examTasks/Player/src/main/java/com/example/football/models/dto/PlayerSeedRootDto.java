package com.example.football.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedRootDto {

    @XmlElement(name = "player")
    private List<PlayerSeedDto> playerSeedDtoList;

    public PlayerSeedRootDto() {
    }

    public List<PlayerSeedDto> getPlayerSeedDtoList() {
        return playerSeedDtoList;
    }

    public void setPlayerSeedDtoList(List<PlayerSeedDto> playerSeedDtoList) {
        this.playerSeedDtoList = playerSeedDtoList;
    }
}
