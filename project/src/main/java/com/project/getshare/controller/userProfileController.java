package com.project.getshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.getshare.model.Credentials;
import com.project.getshare.model.Software;
import com.project.getshare.model.User;
import com.project.getshare.services.CredentialsService;
import com.project.getshare.services.SoftwareService;
import com.project.getshare.services.UserService;
import com.project.getshare.session.SessionData;

@Controller
public class userProfileController {

	@Autowired
	UserService us;
	
	@Autowired
	SessionData sd;
	
	@Autowired
	CredentialsService cs;
	
	@Autowired
	SoftwareService ss;
	
	@RequestMapping(value="/userProfile", method=RequestMethod.GET)
	public String getProfile(Model model) {
		
		User username = sd.getLoggedUser();
		Credentials credentials = sd.getLoggedCredentials();
		model.addAttribute("loggedUser", username);
		model.addAttribute("loggedCredentials", credentials);
		List<Software> ls = ss.getAllSoftware();
		model.addAttribute("listaSoftware", ls);
		model.addAttribute("Software1", new Software());
		return "userProfile";
	}
	
	@RequestMapping(value="/manageUser", method=RequestMethod.GET)
	public String manageUser(@RequestParam String email) {
		Credentials credential = cs.getCredentials(email);
		cs.delete(credential);
		return "redirect:/userProfile";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String deleteSoftware(@PathVariable("id") Long id) {
		ss.deleteSoftware(ss.getSoftwareById(id));
		return "redirect:/userProfile";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String updateSoftware(@PathVariable("id") Long id, @Validated @ModelAttribute("Software1") Software software) {
		
		Software software1 = ss.getSoftwareById(id);
		
		software1.setName(software.getName());
		software1.setDescription(software.getDescription());
		software1.setPublish(software.getPublish());
		software1.setPrice(software.getPrice());
		software1.setSize(software.getSize());
		software1.setVersion(software.getVersion());
		software1.setSoftwarehouse(software.getSoftwarehouse());
		
		ss.saveSoftware(software1);
		return "redirect:/userProfile";
	}
	
}
