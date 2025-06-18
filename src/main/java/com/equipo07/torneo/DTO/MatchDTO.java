package com.equipo07.torneo.DTO;

import java.util.List;

import com.equipo07.torneo.enums.Results;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para transferencia de datos de Match.
 * Incluye IDs y usuarios en forma de UserDTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
    @NotNull(message = "Match ID field cannot be empty")
    private Integer matchId;

    @NotNull(message = "Tournament ID field cannot be empty")
    private Integer tournamentId;

    @NotNull(message = "Player 1 field cannot be empty")
    private UserDTO player1;

    @NotNull(message = "Player 2 field cannot be empty")
    private UserDTO player2;

    @NotNull(message = "Result field cannot be empty")
    private Results result;

    @NotNull(message = "Round field cannot be empty")
    private Integer round;

    private List<UserDTO> players;

    private List<MessageDTO> messages;
}
