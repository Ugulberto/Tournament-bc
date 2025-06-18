package com.equipo07.torneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipo07.torneo.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{

}
