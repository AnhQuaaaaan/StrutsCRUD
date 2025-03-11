package com.example.CRUD.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.example.CRUD.form.UserForm;
import com.example.CRUD.model.User;
import com.example.CRUD.service.UserService;
import com.example.CRUD.service.UserServiceImpl;


public class UserAction extends MappingDispatchAction{
	private UserService userService;
	
	public UserAction() {
		this.userService=new UserServiceImpl();
	}

	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm=(UserForm) form;
		User user = new User(userForm.getUsername(),userForm.getPassword(),userForm.getEmail(),userForm.getPhone(),userForm.getPassword());
		if(userService.addUser(user)!=-1) request.setAttribute("message",  "Add new user successfully!");
		else request.setAttribute("message",  "Something wrong, Cannot add new User!");
		return mapping.findForward("addUsersc");
		
	}
	public ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm=(UserForm) form;
		User user = new User(userForm.getUsername(),userForm.getPassword(),userForm.getEmail(),userForm.getPhone(),userForm.getPassword());
		if(userService.addUser(user)!=-1) request.setAttribute("message",  "Add new user successfully!");
		else request.setAttribute("message",  "Something wrong, Cannot add new User!");
		return mapping.findForward("updateUsersc");
		
	}
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int userId=Integer.parseInt(request.getParameter("id"));
		if(userService.deleteUser(userId)!=-1) request.setAttribute("message",  "Delete user successfully!");
		else request.setAttribute("message",  "Something wrong, Cannot delete User!");
		return mapping.findForward("deleteUsersc");
		
	}
	public ActionForward getUserById(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int userId=Integer.parseInt(request.getParameter("id"));
		User user=userService.getUserById(userId);
		if(user!=null) {
			request.setAttribute("user", user);
		}
		else {
			request.setAttribute("message",  "Something wrong, Cannot get User!");
		}
		return mapping.findForward("getUsersc");
		
	}
	public ActionForward getAllUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<User> list=userService.getAllUsers();
		if(list!=null) {
			request.setAttribute("listUser", list); 	
		}
		else {
			request.setAttribute("abc",  "Something wrong, Cannot get ListUser!");
		}
		return mapping.findForward("getListsc");
	}
}
