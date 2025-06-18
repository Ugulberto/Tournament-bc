package com.equipo07.torneo.model;

import java.util.ArrayList;
import java.util.List;

import com.equipo07.torneo.enums.Results;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa la entidad Match en la base de datos.
 * En ella se indican la identificacion del emparejamiento, la identificacion del torneo al que pertenece, los dos jugadores enfrentados, el resultado del emparejamiento y la ronda del mismo.
*/
@Entity
@Table(name = "MATCHES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchId", unique = true)
    @NotNull(message = "Match ID field cannot be empty")
    private Integer matchId;

    @NotNull(message = "Tournament field cannot be empty")
    @ManyToOne
    @JoinColumn(name = "tournament")
    private Tournament tournament;

    @NotNull(message = "Player 1 field cannot be empty")
    @ManyToOne
    @JoinColumn(name = "player1Id")
    private User player1;

    @NotNull(message = "Player 2 field cannot be empty")
    @ManyToOne
    @JoinColumn(name = "player2Id")
    private User player2;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Result field cannot be empty")
    @Column(name = "result")
    private Results result;

    @NotNull(message = "Round field cannot be empty")
    @Column(name = "round")
    private Integer round;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

}
