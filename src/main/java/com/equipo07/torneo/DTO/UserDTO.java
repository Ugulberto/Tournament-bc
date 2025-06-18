package com.equipo07.torneo.DTO;

import java.util.List;

import com.equipo07.torneo.enums.Ranks;
import com.equipo07.torneo.model.Message;
import com.equipo07.torneo.model.Tournament;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa al User tal y como lo verán otros usuarios de este sistema de torneos.
 * Es idéntico a la clase User pero se eliminan los campos password y role por seguridad.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotNull(message = "ID field cannot be empty")
    private Integer id;

    @NotNull(message = "Username field cannot be empty")
    private String username;

    @NotNull(message = "Email field cannot be empty")
    @Email
    private String email;

    @NotNull(message = "ELO field cannot be empty")
    private Integer elo;

    @NotNull(message = "Rank field cannot be empty")
    private Ranks rank;

    private List<Tournament> tournaments;

    private List<Message> sentMessages;

}
