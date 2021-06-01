package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/searchingredients")   
	public String searchIngredients() {
		return "SearchIngredients";
	}

	@PostMapping("/searchingredientsbyname")
	public String searchIngredientsByName(@RequestParam("search") String name, Model model) {
		List<IngredientsBean> allIngredients = ingredientsDao.searchIngredientsByName(name);
		model.addAttribute("allIngredients", allIngredients);
		return "SearchIngredients";
	}
	
	
	
//	@PostMapping("/searchingredientsbynamejson")
	@RequestMapping(value="/searchingredientsbynamejson",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<List<IngredientsBean>> searchIngredientsByNameJson(@RequestParam("search") String name) {
		List<IngredientsBean> allIngredients = ingredientsDao.searchIngredientsByName(name);
		System.out.println("====> "+allIngredients.size());
		ResponseEntity<List<IngredientsBean>> res = new ResponseEntity<List<IngredientsBean>>(allIngredients, HttpStatus.OK);
		return res;
	}

}
