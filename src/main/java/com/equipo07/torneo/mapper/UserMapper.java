package com.equipo07.torneo.mapper;

import org.springframework.stereotype.Component;

import com.equipo07.torneo.DTO.UserDTO;
import com.equipo07.torneo.enums.Roles;
import com.equipo07.torneo.model.User;

@Component
public class UserMapper {
    public UserDTO convertToDTO(User user) {
        return UserDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .elo(user.getElo())
            .rank(user.getRank())
            .tournaments(user.getTournaments())
            .sentMessages(user.getSentMessages())
            .build();

    }

    public User convertToUser(UserDTO userDTO) {
        return User.builder()
            .id(userDTO.getId())
            .username(userDTO.getUsername())
            .email(userDTO.getEmail())
            .password("") // o null, o lo que quieras
            .elo(userDTO.getElo())
            .rank(userDTO.getRank())
            .role(Roles.USER)
            .tournaments(userDTO.getTournaments())
            .sentMessages(userDTO.getSentMessages())
            .build();

    }
}
