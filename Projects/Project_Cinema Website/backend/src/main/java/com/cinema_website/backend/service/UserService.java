package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.UserDTO;
import com.cinema_website.backend.mapper.UserMapper;
import com.cinema_website.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("all")
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // GET
    public UserDTO getUser(int userId) {
        return userRepository.getUserById(userId);
    }

    public UserDTO getUserByCredentials(String username, String password) {
        return userRepository.getUserByCredentials(username, password);
    }

    public UserDTO getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    // INSERT
    public boolean addUser(UserDTO user) {
        return userRepository.addUser(user);
    }

    // UPDATE
    public boolean updateUser(int userId, UserDTO updatedUser) {
        return userRepository.updateUserById(userId, updatedUser);
    }

    public boolean updateUserStatus(int userId, String updatedStatus) {
        return userRepository.updateUserStatus(userId, updatedStatus);
    }



    // DELETE
    public boolean deleteUser(int userId) {
        return userRepository.deleteUserById(userId);
    }

    // Update last login timestamp for authentication purposes
    public boolean updateLastLogin(int userId) {
        return userRepository.updateLastLogin(userId);
    }
}
