package com.equipo07.torneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equipo07.torneo.model.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long>{

}
