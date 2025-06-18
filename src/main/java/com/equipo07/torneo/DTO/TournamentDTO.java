package com.equipo07.torneo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.equipo07.torneo.enums.TournamentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para Tournament.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentDTO {

    @NotNull(message = "ID field cannot be empty")
    private Integer id;

    @NotNull(message = "Tournament name field cannot be empty")
    private String tournamentName;

    @NotNull(message = "Tournament maximum number of players field cannot be empty")
    private String maxPlayers;

    @NotNull(message = "Tournament status field cannot be empty")
    private TournamentStatus tournamentStatus;

    private List<UserDTO> players = new ArrayList<>();
}
