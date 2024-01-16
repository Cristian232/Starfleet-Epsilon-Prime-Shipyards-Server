package org.starfleet.epsilonprimeshipyards.controller;

import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.starfleet.epsilonprimeshipyards.dto.*;
import org.starfleet.epsilonprimeshipyards.responses.*;
import org.starfleet.epsilonprimeshipyards.service.UserService;
import org.starfleet.epsilonprimeshipyards.constants.Constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody UserDTO userDto) {
        try {
            boolean registrationSuccess = userService.registerUser(userDto);

            if (registrationSuccess) {
                RegistrationResponse response = new RegistrationResponse(true, Constant.SUCCESSFUL_REGISTRATION);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                RegistrationResponse response = new RegistrationResponse(false, Constant.UNSUCCESSFUL_REGISTRATION);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        } catch (DataIntegrityViolationException e) {
            log.error("User registration failed", e);
            RegistrationResponse response = new RegistrationResponse(false,
                    Constant.FAILED_REGISTRATION + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<RegistrationResponse> loginUser(@RequestBody UserDTO userDto) {
        try {
            UserDTO userExists = userService.getUserByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());

            if (userExists != null) {
                RegistrationResponse response = new RegistrationResponse(true, Constant.SUCCESSFUL_LOGIN);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                RegistrationResponse response = new RegistrationResponse(false, Constant.INVALID_LOGIN);
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("User login failed", e);
            RegistrationResponse response = new RegistrationResponse(false, Constant.FAILED_LOGIN + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/profileManagement")
    public ResponseEntity<ProfileManagementResponse> getProfileManagement(@RequestBody UserDTO userDto) {
        try {
            UserDTO userExists = userService.getUserByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
            if (userExists != null) {
                ProfileManagementResponse response = new ProfileManagementResponse(true, "User profile management");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ProfileManagementResponse response = new ProfileManagementResponse(true, "User profile management " +
                        "unavailable");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("Profile retrieval failed", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/productCatalog")
    public ResponseEntity<?> productCatalog(@RequestBody UserDTO userDto) {

        try {
            UserDTO user = userService.getUserByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
            if (user != null) {
                ProductCatalogResponse response = new ProductCatalogResponse(true, "Product catalogue");
                List<ProductItem> products = userService.getProductsByCatalog(user);
                return new ResponseEntity<>(products, HttpStatus.OK);
            } else {
                ProductCatalogResponse response = new ProductCatalogResponse(false, "Product catalogue " +
                        "unavailable");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("Profile retrieval failed", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> order(@RequestBody UserOrderRequest request) {
        try {
            UserDTO user = userService.getUserByUsernameAndPassword(request.getUser().getUsername(), request.getUser().getPassword());
            if (user != null) {
                OrderResponse response = new OrderResponse(true, "Order available", request);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                OrderResponse response = new OrderResponse(false, "Order unavailable", request);
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("Profile retrieval failed", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}