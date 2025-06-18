package com.equipo07.torneo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equipo07.torneo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
