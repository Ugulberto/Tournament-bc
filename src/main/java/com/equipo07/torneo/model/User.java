package com.equipo07.torneo.model;

import java.util.ArrayList;
import java.util.List;

import com.equipo07.torneo.enums.Ranks;
import com.equipo07.torneo.enums.Roles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa la entidad Usuario en la base de datos.
 * Contiene su identificador, nombre de usuario, email, contraseña, puntuación ELO, rango competitivo y rol (usuario o administrador).
 */
@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true)
    @NotNull(message = "ID field cannot be empty")
    private Integer id;

    @NotNull(message = "Username field cannot be empty")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Email field cannot be empty")
    @Email
    @Column(name = "email")
    private String email;
    
    @NotNull(message = "Password field cannot be empty")
    @Size(min = 8, max = 64)
    @Column(name = "password")
    private String password;

    @NotNull(message = "ELO field cannot be empty")
    @Column(name = "elo")
    private Integer elo;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Rank field cannot be empty")
    @Column(name = "rank")
    private Ranks rank;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role field cannot be empty")
    @Column(name = "role")
    private Roles role;

    @ManyToMany(mappedBy = "players")
    private List<Tournament> tournaments = new ArrayList<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sentMessages = new ArrayList<>();

}
