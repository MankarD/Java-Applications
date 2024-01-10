package com.ticket.service;

import com.ticket.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByUserId(Long userId);

    List<UserDTO> getAllUser();

    UserDTO updateUser(Long userId, UserDTO userDTO);

    String deleteUserByUserId(Long userId);
}
