package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.IngredientsBean;
import com.bean.UserBean;
import com.dao.IngredientsDao;

@Controller
public class IngredientsController {

	@Autowired
	IngredientsDao ingredientsDao;
	
	@GetMapping("/newingredient")
	public String newIngredient(Model model) {
		model.addAttribute("ingredient", new IngredientsBean());
		return "NewIngredient";
	}

	@PostMapping("/saveingredient")
	public String saveIngredient(IngredientsBean ingredient, HttpSession session) {
		UserBean user = (UserBean) session.getAttribute("user");

		if (user.getRole() == UserBean.Role.ADMIN.getRole()) {
			ingredient.setActive(1);
		} else {
			ingredient.setActive(0);
		}
		ingredientsDao.saveIngredient(ingredient);
		return "";
	}
}










