package com.equipo07.torneo.DTO;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para Message. (Con getters y setters usando lombok)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    @NotNull(message = "Message ID field cannot be empty")
    private Integer messageId;

    @NotNull(message = "Sender field cannot be empty")
    private UserDTO sender;

    @NotNull(message = "Message content cannot be null")
    private String messageContent;

    @NotNull(message = "Timestamp field cannot be empty")
    private LocalDateTime timestamp;

    @NotNull(message = "Match ID field cannot be empty")
    private Integer matchId;

    @NotNull(message = "Tournament ID field cannot be empty")
    private Integer tournamentId;

}
