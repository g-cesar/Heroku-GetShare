package com.project.getshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.getshare.model.Credentials;
import com.project.getshare.model.User;
import com.project.getshare.services.CredentialsService;
import com.project.getshare.validator.CredentialsValidator;
import com.project.getshare.validator.UserValidator;

@Controller
public class AuthenticationController {

	@Autowired
	CredentialsService cs;
	
	@Autowired
	UserValidator uv;
	
	@Autowired
	CredentialsValidator cv;
	
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String showRegisterUserForm(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("credentialsForm", new Credentials());
		return "index";
	}
	
	@RequestMapping(value={"/"}, method=RequestMethod.POST)
	public String registerUser(@Validated @ModelAttribute("userForm") User user, BindingResult userBindingResult, @Validated @ModelAttribute("credentialsForm") Credentials credentials, BindingResult credentialsBindingResult, Model model) {
		this.uv.validate(user, userBindingResult);
		this.cv.validate(credentials, credentialsBindingResult);
		
		if(!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			credentials.setUser(user);
			credentials.setRole(Credentials.DEFAULT_ROLE);
			cs.saveCredentials(credentials);
			return "redirect:/";
		}
		return "index";
	}
	
	@RequestMapping(value= {"/admin/signup"}, method=RequestMethod.GET)
	public String showRegisterAdminForm(Model model) {
		model.addAttribute("adminForm", new User());
		model.addAttribute("credentialsForm", new Credentials());
		return "adminForm";
	}
	
	@RequestMapping(value={"/admin/signup/addAdmin"}, method=RequestMethod.POST)
	public String registerAdmin(@Validated @ModelAttribute("adminForm") User user, BindingResult userBindingResult, @Validated @ModelAttribute("credentialsForm") Credentials credentials, BindingResult credentialsBindingResult, Model model) {
		this.uv.validate(user, userBindingResult);
		this.cv.validate(credentials, credentialsBindingResult);
		
		if(!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			credentials.setUser(user);
			credentials.setRole(Credentials.ADMIN_ROLE);
			cs.saveCredentials(credentials);
			return "redirect:/";
		}
		return "index";
	}
	
}