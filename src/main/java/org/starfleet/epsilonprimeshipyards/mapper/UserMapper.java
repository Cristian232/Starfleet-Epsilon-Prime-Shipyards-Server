package org.starfleet.epsilonprimeshipyards.mapper;

import org.springframework.stereotype.Component;
import org.starfleet.epsilonprimeshipyards.dto.UserDTO;
import org.starfleet.epsilonprimeshipyards.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public  static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    public  static User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public  static List<UserDTO> usersToUserDTOs(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(userToUserDTO(user));
        }
        return userDTOs;
    }
}