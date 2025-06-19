package com.equipo07.torneo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.equipo07.torneo.DTO.MatchDTO;
import com.equipo07.torneo.model.Match;
import com.equipo07.torneo.repository.TournamentRepository;

@Component
public class MatchMapper {

    private final UserMapper userMapper;
    private final MessageMapper messageMapper;
    private final TournamentRepository tournamentRepository;

    public MatchMapper(UserMapper userMapper, MessageMapper messageMapper, TournamentRepository tournamentRepository) {
        this.userMapper = userMapper;
        this.messageMapper = messageMapper;
        this.tournamentRepository = tournamentRepository;
    }

    public MatchDTO convertToMatchDTO(Match match) {
        return new MatchDTO(
            match.getMatchId(),
            match.getTournament().getId(),
            userMapper.convertToDTO(match.getPlayer1()),
            userMapper.convertToDTO(match.getPlayer2()),
            match.getResult(),
            match.getRound(),
            // Lista de jugadores, útil si quieres mantenerlos juntos en un campo adicional
            List.of(
                userMapper.convertToDTO(match.getPlayer1()),
                userMapper.convertToDTO(match.getPlayer2())
            ),
            match.getMessages()
                .stream()
                .map(messageMapper::convertToMessageDTO)
                .collect(Collectors.toList())
        );
    }

    public Match convertToMatch(MatchDTO dto) {
        return Match.builder()
            .matchId(dto.getMatchId())
            .tournament(tournamentRepository.findById(dto.getTournamentId().longValue()).orElseThrow(
                () -> new IllegalArgumentException("Tournament with ID " + dto.getTournamentId() + " not found")
            ))
            .player1(userMapper.convertToUser(dto.getPlayer1()))
            .player2(userMapper.convertToUser(dto.getPlayer2()))
            .result(dto.getResult())
            .round(dto.getRound())
            .messages(
                dto.getMessages() != null
                    ? dto.getMessages()
                        .stream()
                        .map(messageMapper::convertToMessage)
                        .collect(Collectors.toList())
                    : List.of()
            )
            .build();
    }
}
