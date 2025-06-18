package com.equipo07.torneo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa la entidad Message en la base de datos.
 * En ella se indican el identificador del mensaje, la identificacion del torneo y del emparejamiento al que pertenece, el usuario quelo envía y la fecha en la que se envió.
*/
@Entity
@Table(name = "MESSAGES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId", unique = true)
    @NotNull(message = "Message ID field cannot be empty")
    private Integer messageId;

    @NotNull(message = "Sender field cannot be empty")
    @ManyToOne
    @JoinColumn(name = "senderId")
    private User sender;

    @NotNull(message = "Message content cannot be null")
    @Column(name = "messageContent")
    private String messageContent;

    @NotNull(message = "Timestamp field cannot be empty")
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    
    @ManyToOne
    @JoinColumn(name = "match")
    @NotNull(message = "Match field cannot be empty")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "tournament")
    @NotNull(message = "Tournament field cannot be empty")
    private Tournament tournament;

}

