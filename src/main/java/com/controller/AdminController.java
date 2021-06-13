package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dao.IngredientsDao;
import com.dao.UserDao;

@Controller
public class AdminController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	IngredientsDao ingredientDao;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		int totalUsers = userDao.getAllUsers().size();
		int totalIngredients = ingredientDao.getAllIngredients().size();
		model.addAttribute("totalUsers",totalUsers);
		model.addAttribute("totalIngredients",totalIngredients);
		return "AdminDashboard";
	}
}
