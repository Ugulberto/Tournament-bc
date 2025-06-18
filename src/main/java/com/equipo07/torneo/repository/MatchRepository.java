package com.equipo07.torneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipo07.torneo.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{

}
