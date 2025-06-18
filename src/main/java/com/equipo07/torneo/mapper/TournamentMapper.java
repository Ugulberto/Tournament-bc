package com.equipo07.torneo.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.equipo07.torneo.DTO.TournamentDTO;
import com.equipo07.torneo.model.Tournament;

@Component
public class TournamentMapper {

    private final UserMapper userMapper;

    public TournamentMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public TournamentDTO convertToTournamentDTO(Tournament tournament) {
        return TournamentDTO.builder()
            .id(tournament.getId())
            .tournamentName(tournament.getTournamentName())
            .maxPlayers(tournament.getMaxPlayers())
            .tournamentStatus(tournament.getTournamentStatus())
            .players(
                tournament.getPlayers()
                    .stream()
                    .map(userMapper::convertToDTO)
                    .collect(Collectors.toList())
            )
            .build();
    }

    public Tournament convertToTournament(TournamentDTO dto) {
        return Tournament.builder()
            .id(dto.getId())
            .tournamentName(dto.getTournamentName())
            .maxPlayers(dto.getMaxPlayers())
            .tournamentStatus(dto.getTournamentStatus())
            .players(
                dto.getPlayers()
                    .stream()
                    .map(userMapper::convertToUser)
                    .collect(Collectors.toList())
            )
            .build();
    }
}
