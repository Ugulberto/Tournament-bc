package com.equipo07.torneo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipo07.torneo.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
