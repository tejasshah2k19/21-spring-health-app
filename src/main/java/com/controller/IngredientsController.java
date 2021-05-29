package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:/getallingredients";
	}

	@GetMapping("/getallingredients")
	public String getAllIngredients(Model model) {
		List<IngredientsBean> allIngredients = ingredientsDao.getAllIngredients();
		model.addAttribute("allIngredients", allIngredients);
		return "ListIngredients";
	}

	@GetMapping("/deleteingredients/{id}")
	public String deleteIngredients(@PathVariable("id") int id) {

		ingredientsDao.deleteIngredientById(id);
		
		return "redirect:/getallingredients";
	}

}
