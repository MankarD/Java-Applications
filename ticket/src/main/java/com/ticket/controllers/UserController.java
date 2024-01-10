package com.ticket.controllers;

import com.ticket.dto.UserDTO;
import com.ticket.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save a user in the database"
    )
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO dto = userService.createUser(userDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User REST API",
            description = "Get User REST API is used to get a user from the database"
    )
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByUserId(@PathVariable Long userId) {
        UserDTO dto = userService.getUserByUserId(userId);
        return new ResponseEntity<>(dto, HttpStatus.FOUND);
    }

    @Operation(
            summary = "Get All User REST API",
            description = "Get All User REST API is used to get all users from the database"
    )
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> dtos = userService.getAllUser();
        return new ResponseEntity<>(dtos, HttpStatus.FOUND);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a user in the database"
    )
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        UserDTO dto = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a user from the database"
    )

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        String status = userService.deleteUserByUserId(userId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
