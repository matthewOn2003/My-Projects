package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.UserDTO;
import com.cinema_website.backend.mapper.UserMapper;
import com.cinema_website.backend.model.User;
import com.cinema_website.backend.util.UserUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Repository
public class UserRepository {

    private final UserMapper userMapper;

    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // SELECT
    public UserDTO getUserById(int userId) {
        User user = userMapper.getUserById(userId);
        if (user == null) {
            return null;
        }
        return UserUtils.toUserDTO(user);
    }

    public UserDTO getUserByCredentials(String username, String password) {
        User user = userMapper.getUserByCredentials(username, password);
        if (user == null) {
            return null;
        }
        return UserUtils.toUserDTO(user);
    }
    public UserDTO getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        return UserUtils.toUserDTO(user);
    }
    public UserDTO getUserByEmail(String email) {
        User user = userMapper.getUserByEmail(email);
        if (user == null) {
            return null;
        }
        return UserUtils.toUserDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        try {
            List<User> users = userMapper.getAllUsers();
            if (users == null || users.isEmpty()) {
                return null;
            }

            List<UserDTO> userDTOS = new ArrayList<>();
            for (User user : users) {
                UserDTO element = UserUtils.toUserDTO(user);
                userDTOS.add(element);
            }

            return userDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // INSERT
    public boolean addUser(UserDTO user) {
        try {
            return userMapper.addUser(UserUtils.toUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicating insertion failed
        }
    }

    // UPDATE
    public boolean updateUserById(int userId, UserDTO updatedUser) {
        try {
            return userMapper.updateUserById(userId, UserUtils.toUser(updatedUser));
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicating update failed
        }
    }


    public boolean updateUserStatus(int userId, String status) {
        try {
            return userMapper.updateUserStatus(userId, status);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicating update failed
        }
    }

    // DELETE
    public boolean deleteUserById(int userId) {
        try {
            return userMapper.deleteUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicating deletion failed
        }
    }

    // Update last login timestamp for authentication purposes
    public boolean updateLastLogin(int userId) {
        try {
            return userMapper.updateLastLogin(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicating update failed
        }
    }
}
