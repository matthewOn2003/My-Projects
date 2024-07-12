package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserById(int userId);
    List<User> getAllUsers();
    User getUserByCredentials(@Param("username") String username, @Param("password") String password);
    boolean addUser(User user);
    boolean updateUserById(@Param("userId") int userId, @Param("user") User user);
    boolean updateUserStatus(@Param("userId") int userId, @Param("status") String status);
    boolean deleteUserById(int userId);
    boolean updateLastLogin(@Param("userId") int userId);
}
