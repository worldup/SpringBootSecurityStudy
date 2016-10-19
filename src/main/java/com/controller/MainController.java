package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Account;
import com.domain.Role;
import com.domain.UserDetailsImpl;
import com.repository.AccountRepository;
import com.repository.RoleRepository;

@Controller
public class MainController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String getMain() {
		return "index";
	}

	@RequestMapping("/users")
	public void users() {
	}

	@RequestMapping("/admin")
	public void admin() {
	}

	@RequestMapping("/login")
	public void login() {
	}

	@RequestMapping("/registrationForm")
	public void registrationForm() {
	}

	@RequestMapping("/posts/@Id")
	public ModelAndView getPosts() {
		return null;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Account account){
		Role role = roleRepository.findByRole("ROLE_USER");
		account.addRole(role);
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account = accountRepository.save(account);
		
		UserDetailsImpl userDetails = new UserDetailsImpl(account);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
		
	}
}
