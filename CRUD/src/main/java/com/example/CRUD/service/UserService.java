package com.example.CRUD.service;

import java.util.List;

import com.example.CRUD.model.User;

public interface UserService {
	 int addUser(User user);
	 int updateUser(User user,int userId);
	 int deleteUser(int userId);
	 User getUserById(int userId);
	 List<User> getAllUsers();
}
