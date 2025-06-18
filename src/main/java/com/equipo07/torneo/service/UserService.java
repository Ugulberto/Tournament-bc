package com.equipo07.torneo.service;

import org.springframework.stereotype.Service;

import com.equipo07.torneo.DTO.UserDTO;
import com.equipo07.torneo.mapper.UserMapper;
import com.equipo07.torneo.model.User;
import com.equipo07.torneo.repository.UserRepository;

@Service
public class UserService {
    // lógica
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO getUserById(Integer id) {
        User user = userRepository.getById(id.longValue());
        return userMapper.convertToDTO(user);
    }
}
