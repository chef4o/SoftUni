package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedDto;
import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//ToDo - Implement all methods
@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String RESOURCES_XML_PLAYERS_PATH = "src/main/resources/files/xml/players.xml";
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper,
                             ValidationUtil validationUtil, XmlParser xmlParser,
                             TownService townService, TeamService teamService,
                             StatService statService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_XML_PLAYERS_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            xmlParser
                    .fromFile(RESOURCES_XML_PLAYERS_PATH, PlayerSeedRootDto.class)
                    .getPlayerSeedDtoList()
                    .stream()
                    .filter(playerSeedDto -> {
                        boolean isValid = validationUtil.isValid(playerSeedDto);
                        output.append(getResponse(playerSeedDto.getFirstName(),
                                playerSeedDto.getLastName(), playerSeedDto.getPosition(), isValid));
                        return isValid;
                    })
                    .map(playerSeedDto -> {
                        Player player = modelMapper.map(playerSeedDto, Player.class);
                        player.setTown(townService.findByName(playerSeedDto.getTown().getName()));
                        player.setTeam(teamService.findByName(playerSeedDto.getTeam().getName()));
                        player.setStat(statService.findById(playerSeedDto.getStat().getId()));
                        return player;
                    })
                    .forEach(playerRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    private String getResponse(String firstName, String lastName, String rating, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Player %s %s - %s%s",
                firstName, lastName, rating, System.lineSeparator())
                : String.format("Invalid Player%s", System.lineSeparator());
    }

    @Override
    public String exportBestPlayers() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bornAfter = LocalDate.parse("01-01-1995", formatter);
        LocalDate bornBefore = LocalDate.parse("01-01-2003", formatter);

        StringBuilder bestPlayers = new StringBuilder();

        playerRepository
                .findAllByBirthdayBetweenOrderByShootingDescPassingDescEnduranceDescLastName(
                        bornAfter, bornBefore)
                .forEach(player -> {
                    bestPlayers.append(String.format(
                            "Player - %s %s\n" +
                            "\tPosition - %s\n" +
                            "\tTeam - %s\n" +
                            "\tStadium - %s\n",
                            player.getFirstName(), player.getLastName(),
                            player.getPosition(),
                            player.getTeam(),
                            player.getTeam().getStadiumName()
                    )).append(System.lineSeparator());
                });
        return bestPlayers.toString().trim();
    }
}
