package org.starfleet.epsilonprimeshipyards.service;

import org.springframework.stereotype.Service;
import org.starfleet.epsilonprimeshipyards.dto.UserDTO;
import org.starfleet.epsilonprimeshipyards.mapper.UserMapper;
import org.starfleet.epsilonprimeshipyards.model.User;
import org.starfleet.epsilonprimeshipyards.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(userMapper::userToUserDTO).orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserDTOs(users);
    }

}
