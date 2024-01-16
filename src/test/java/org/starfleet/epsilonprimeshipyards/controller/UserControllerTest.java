package org.starfleet.epsilonprimeshipyards.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.starfleet.epsilonprimeshipyards.constants.Constant;
import org.starfleet.epsilonprimeshipyards.dto.UserDTO;
import org.starfleet.epsilonprimeshipyards.responses.RegistrationResponse;
import org.starfleet.epsilonprimeshipyards.service.UserService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUser_successfulRegistration_returnsCreatedStatus() {
        UserDTO userDto = new UserDTO(); // TODO: set fields
        when(userService.registerUser(any(UserDTO.class))).thenReturn(true);

        ResponseEntity<RegistrationResponse> responseEntity = userController.registerUser(userDto);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        assertTrue(Objects.requireNonNull(responseEntity.getBody()).isSuccess());
        assertEquals(responseEntity.getBody().getMessage(), Constant.SUCCESSFUL_REGISTRATION);
    }

    @Test
    public void registerUser_unsuccessfulRegistration_returnsBadRequestStatus() {
        UserDTO userDto = new UserDTO(); // TODO: set fields
        when(userService.registerUser(any(UserDTO.class))).thenReturn(false);

        ResponseEntity<RegistrationResponse> responseEntity = userController.registerUser(userDto);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertFalse(Objects.requireNonNull(responseEntity.getBody()).isSuccess());
        assertEquals(responseEntity.getBody().getMessage(), Constant.UNSUCCESSFUL_REGISTRATION);
    }

    @Test
    public void registerUser_throwsException_returnsInternalServerErrorStatus() {
        UserDTO userDto = new UserDTO(); // TODO: set fields
        when(userService.registerUser(any(UserDTO.class))).thenThrow(new DataIntegrityViolationException("User already exists"));

        ResponseEntity<RegistrationResponse> responseEntity = userController.registerUser(userDto);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertFalse(Objects.requireNonNull(responseEntity.getBody()).isSuccess());
        assertEquals(responseEntity.getBody().getMessage(), Constant.FAILED_REGISTRATION + "User already exists");
    }
}