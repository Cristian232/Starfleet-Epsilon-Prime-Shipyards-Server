package org.starfleet.epsilonprimeshipyards.service;
import org.starfleet.epsilonprimeshipyards.responses.ProductItem;
import org.starfleet.epsilonprimeshipyards.dto.UserDTO;
import org.starfleet.epsilonprimeshipyards.mapper.UserMapper;
import org.starfleet.epsilonprimeshipyards.model.User;
import org.starfleet.epsilonprimeshipyards.repository.UserRepository;

import org.springframework.dao.DataIntegrityViolationException; // import needed for exception handling
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(UserMapper::userToUserDTO).orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.usersToUserDTOs(users);
    }

    public boolean registerUser(UserDTO userDto) {
        try {
            User user = UserMapper.userDTOToUser(userDto);
            System.out.println("User registration " + user);
            if (userRepository.findByUsername(user.getUsername()).isEmpty()){
                userRepository.save(user);
            } else {
                return false;
            }
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public UserDTO getUserByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        System.out.println("User log in " + user);
        return user != null ? UserMapper.userToUserDTO(user) : null;
    }

    public UserDTO getProfile(Long id) {
        return getUserById(id);
    }

    public List<ProductItem> getProductsByCatalog(UserDTO user) {
        List<ProductItem> productList = new ArrayList<>();

        productList.add(new ProductItem( "Engine",2L));
        productList.add(new ProductItem("Torpedo",5L));

        return productList;
    }
}
