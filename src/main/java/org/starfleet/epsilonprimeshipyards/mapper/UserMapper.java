package org.starfleet.epsilonprimeshipyards.mapper;

import org.springframework.stereotype.Component;
import org.starfleet.epsilonprimeshipyards.dto.UserDTO;
import org.starfleet.epsilonprimeshipyards.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());

        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());

        return user;
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(userToUserDTO(user));
        }
        return userDTOs;
    }
}