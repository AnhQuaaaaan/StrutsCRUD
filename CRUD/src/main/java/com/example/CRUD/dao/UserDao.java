package com.example.CRUD.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.CRUD.model.User;

public interface UserDao {
	 int addUser(User user);
	 int updateUser(User user,int userId);
	 int deleteUser(int userId);
	 User getUserById(int userId);
	 List<User> getAllUsers();
}
