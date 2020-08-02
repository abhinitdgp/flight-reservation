package com.abhishek.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhishek.flightreservation.entities.User;
import com.abhishek.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Bean
	PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName);
		return "login/registerUser";

	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName);
		return "login/login";

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName + " " + user);

		user.setPassword(encoder.encode(user.getPassword()));

		userRepository.save(user);
		return "login/login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName + " and the email is: " + email);
		User user = userRepository.findByEmail(email);
//		String encodedPass = encoder.encode(password);
		if (encoder.matches(password, user.getPassword())){
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid username/password. Please try again.");
			return "login/login";
		}

	}
}
