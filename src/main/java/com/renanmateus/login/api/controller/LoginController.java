package com.renanmateus.login.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/login" })
public class LoginController {

	@GetMapping
	public String login() {
		return "login";
	}

	@PostMapping
	public String logar() {
		return "login";

	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
		
	}
	
	
}
