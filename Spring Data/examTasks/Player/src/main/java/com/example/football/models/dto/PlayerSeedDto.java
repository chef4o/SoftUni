package com.example.football.models.dto;

import com.example.football.constants.Position;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement
    private String position;
    @XmlElement(name = "town")
    private PlayerTownSeedDto town;
    @XmlElement(name = "team")
    private PlayerTeamSeedDto team;
    @XmlElement(name = "stat")
    private PlayerStatSeedDto stat;

    public PlayerSeedDto() {
    }

    @Size(min = 3)
    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Size(min = 3)
    @NotBlank
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @NotBlank
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PlayerTownSeedDto getTown() {
        return town;
    }

    public void setTown(PlayerTownSeedDto town) {
        this.town = town;
    }

    public PlayerTeamSeedDto getTeam() {
        return team;
    }

    public void setTeam(PlayerTeamSeedDto team) {
        this.team = team;
    }

    public PlayerStatSeedDto getStat() {
        return stat;
    }

    public void setStat(PlayerStatSeedDto stat) {
        this.stat = stat;
    }
}
