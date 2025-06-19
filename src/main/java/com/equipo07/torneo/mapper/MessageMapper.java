package com.equipo07.torneo.mapper;

import org.springframework.stereotype.Component;

import com.equipo07.torneo.DTO.MessageDTO;
import com.equipo07.torneo.model.Message;
import com.equipo07.torneo.repository.MatchRepository;
import com.equipo07.torneo.repository.TournamentRepository;

@Component
public class MessageMapper {

    private final UserMapper userMapper;
    private final MatchRepository matchRepository;
    private final TournamentRepository tournamentRepository;

    public MessageMapper(UserMapper userMapper, MatchRepository matchRepository, TournamentRepository tournamentRepository) {
        this.userMapper = userMapper;
        this.matchRepository = matchRepository;
        this.tournamentRepository = tournamentRepository;
    }

    public MessageDTO convertToMessageDTO(Message message) {
        return MessageDTO.builder()
            .messageId(message.getMessageId().hashCode()) // Convertimos UUID a Integer para cumplir el tipo del DTO
            .sender(userMapper.convertToDTO(message.getSender()))
            .messageContent(message.getMessageContent())
            .timestamp(message.getTimestamp())
            .matchId(message.getMatch().getMatchId())
            .tournamentId(message.getTournament().getId())
            .build();
    }

    public Message convertToMessage(MessageDTO dto) {
        return Message.builder()
            .messageId(java.util.UUID.nameUUIDFromBytes(dto.getMessageId().toString().getBytes())) // Reconstruye el UUID desde el ID en Integer
            .sender(userMapper.convertToUser(dto.getSender()))
            .messageContent(dto.getMessageContent())
            .timestamp(dto.getTimestamp())
            .match(matchRepository.findById(dto.getMatchId().longValue()).orElseThrow(
                () -> new IllegalArgumentException("Match with ID " + dto.getMatchId() + " not found")
            ))
            .tournament(tournamentRepository.findById(dto.getTournamentId().longValue()).orElseThrow(
                () -> new IllegalArgumentException("Tournament with ID " + dto.getTournamentId() + " not found")
            ))
            .build();
    }
}
