package com.project.getshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.getshare.model.Credentials;
import com.project.getshare.model.Software;
import com.project.getshare.model.SoftwareHouse;
import com.project.getshare.model.User;
import com.project.getshare.services.SoftwareHouseService;
import com.project.getshare.services.SoftwareService;
import com.project.getshare.session.SessionData;
import com.project.getshare.validator.SoftwareHouseValidator;
import com.project.getshare.validator.SoftwareValidator;

@Controller
public class StoreController {
	
	@Autowired
	private SessionData sessionData;
	
	@Autowired
	private SoftwareHouseService shs;
	
	@Autowired
	private SoftwareService ss;
	
	@Autowired
	private SoftwareHouseValidator softwareHouseValidator;
	
	@Autowired
	private SoftwareValidator softwareValidator;
	
	@RequestMapping(value="/store", method=RequestMethod.GET)
	public String saveSoftwareHouse(@ModelAttribute SoftwareHouse softwarehouse, @ModelAttribute Software software, Model model) {
		User username = sessionData.getLoggedUser();
		Credentials credentials = sessionData.getLoggedCredentials();
		model.addAttribute("loggedUser", username);
		model.addAttribute("loggedCredentials", credentials);
		List<SoftwareHouse> lsh = shs.getAllSoftwarehouse();
		model.addAttribute("listaSoftwareHouse", lsh);
		model.addAttribute("SoftwareHouse", new SoftwareHouse());
		List<Software> ls = ss.getAllSoftware();
		model.addAttribute("listaSoftware", ls);  
		model.addAttribute("Software", new Software());
		model.addAttribute("Software1", new Software());
		return "store";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String saveSoftwareHousePost(@Validated @ModelAttribute("SoftwareHouse") SoftwareHouse softwarehouse, BindingResult bindingResult) {
		this.softwareHouseValidator.validate(softwarehouse, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			User user = sessionData.getLoggedUser();
			softwarehouse.setUser(user);
			shs.saveSoftwareHouse(softwarehouse);
			return "redirect:/store";
		}else {
			return "store";
		}
	}
	
	@RequestMapping(value="/addSoftware", method=RequestMethod.POST)
	public String saveSoftwarePost(@Validated @ModelAttribute("Software") Software software,  BindingResult bindingResult) {
		this.softwareValidator.validate(software, bindingResult);
				
		if(!bindingResult.hasErrors()) {
			User user = sessionData.getLoggedUser();
			software.setUser(user);
			software.setSoftwarehouse(shs.getSoftwareHouseById(software.getSoftwarehouse().getId()));
			ss.saveSoftware(software);
			return "redirect:/store";
		}else {
			return "store";
		}
	}
	
}