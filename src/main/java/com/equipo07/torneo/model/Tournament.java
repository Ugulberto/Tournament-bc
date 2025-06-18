package com.equipo07.torneo.model;

import java.util.ArrayList;
import java.util.List;

import com.equipo07.torneo.enums.TournamentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa la entidad Tournament en la base de datos.
 * Contiene diversos campos: su identificador, su nombre, su maximo numero de jugadores, su estado en el momento en el que se consulta y, por último, los jugadores inscritos a él.
*/
@Entity
@Table(name = "TOURNAMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournamentId", unique = true)
    @NotNull(message = "ID field cannot be empty")
    private Integer id;

    @NotNull(message = "Tournament name field cannot be empty")
    @Column(name = "tournamentName")
    private String tournamentName;

    @NotNull(message = "Tournament maximum number of players field cannot be empty")
    @Column(name = "tournamentMaxPlayers")
    private String maxPlayers;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tournament status field cannot be empty")
    @Column(name = "tournamentStatus")
    private TournamentStatus tournamentStatus;

    @ManyToMany
    @JoinTable(
        name = "tournamentPlayers",
        joinColumns = @JoinColumn(name = "tournamentId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> players = new ArrayList<>();

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

}
