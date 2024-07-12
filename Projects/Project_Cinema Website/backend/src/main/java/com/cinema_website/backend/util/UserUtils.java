package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.UserDTO;
import com.cinema_website.backend.model.User;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SuppressWarnings("all")
public class UserUtils {

    // Convert Strings to Timestamps
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // parse User to UserDTO
    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFullName(user.getFullName());
        userDTO.setRole(user.getRole());
        userDTO.setStatus(user.getStatus());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        // Convert Timestamps to String format (assuming format "yyyy-MM-dd HH:mm:ss")
        if (user.getBirthDate() != null) {
            userDTO.setBirthDate(dateFormat.format(user.getBirthDate()));
        }
        if (user.getLastLogin() != null) {
            userDTO.setLastLogin(dateFormat.format(user.getLastLogin()));
        }
        if (user.getCreatedAt() != null) {
            userDTO.setCreatedAt(dateFormat.format(user.getCreatedAt()));
        }
        if (user.getUpdatedAt() != null) {
            userDTO.setUpdatedAt(dateFormat.format(user.getUpdatedAt()));
        }

        return userDTO;
    }

    // parse UserDTO to User
    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        try {
            if (userDTO.getBirthDate() != null) {
                user.setBirthDate(new Timestamp(dateFormat.parse(userDTO.getBirthDate()).getTime()));
            }
            if (userDTO.getLastLogin() != null) {
                user.setLastLogin(new Timestamp(dateFormat.parse(userDTO.getLastLogin()).getTime()));
            }
            if (userDTO.getCreatedAt() != null) {
                user.setCreatedAt(new Timestamp(dateFormat.parse(userDTO.getCreatedAt()).getTime()));
            }
            if (userDTO.getUpdatedAt() != null) {
                user.setUpdatedAt(new Timestamp(dateFormat.parse(userDTO.getUpdatedAt()).getTime()));
            }
        } catch (Exception e) {
            // Log detailed information about the error
            System.err.println("Failed to parse date string: " + e.getMessage());
            if (userDTO.getBirthDate() != null) {
                System.err.println("BirthDate string: " + userDTO.getBirthDate());
            }
            if (userDTO.getLastLogin() != null) {
                System.err.println("LastLogin string: " + userDTO.getLastLogin());
            }
            if (userDTO.getCreatedAt() != null) {
                System.err.println("CreatedAt string: " + userDTO.getCreatedAt());
            }
            if (userDTO.getUpdatedAt() != null) {
                System.err.println("UpdatedAt string: " + userDTO.getUpdatedAt());
            }
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return user;
    }
}
