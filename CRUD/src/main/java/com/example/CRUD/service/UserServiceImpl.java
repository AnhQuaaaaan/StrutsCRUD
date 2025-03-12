package com.example.CRUD.service;

import java.util.List;

import com.example.CRUD.dao.UserDao;
import com.example.CRUD.dao.UserDaoImpl;
import com.example.CRUD.model.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	

	public UserServiceImpl() {
		this.userDao= new UserDaoImpl();
	}

	public int addUser(User user) {
		try{
			return userDao.addUser(user);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}

	public int updateUser(User user,int userId) {
        try {
            return userDao.updateUser(user,userId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteUser(int userId) {
        try {
            return userDao.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public User getUserById(int userId) {
        try {
            return userDao.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
