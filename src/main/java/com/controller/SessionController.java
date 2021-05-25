package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@GetMapping("/login")
	public String login() {

		return "Login";
	}

	@GetMapping("signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("saveuser")
	public String saveUser(UserBean user) {
		// fn em pass
		user.setRole(UserBean.Role.USER.getRole());
		userDao.saveUser(user);
		return "redirect:/login";
	}

	@PostMapping("authenticate")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password,Model model,HttpSession session) {
		UserBean user = userDao.authenticate(email, password);
		if (user == null) {
			//invalid credentials...
			model.addAttribute("msg","<font color='red'>Invalid Credentials</font>");
			return "Login";
		} else {

			session.setAttribute("user", user);
			if (user.getRole() == UserBean.Role.USER.getRole()) {
				return "UserHome";
			} else if (user.getRole() == UserBean.Role.ADMIN.getRole()) {
				return "AdminDashboard";
			} else {
				return "Login";
				//mail 
			}
		}
	}

}
