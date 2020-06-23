package com.project.getshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.getshare.model.Credentials;
import com.project.getshare.model.Software;
import com.project.getshare.model.User;
import com.project.getshare.services.SoftwareService;
import com.project.getshare.session.SessionData;

@Controller
public class softwareController {

	@Autowired
	SoftwareService ss;
	
	@Autowired
	SessionData sd;
	
	@RequestMapping(value="/software/{id}", method=RequestMethod.GET)
	public String getSoftware(@PathVariable Long id, Model model) {
		
		User username = sd.getLoggedUser();
		Credentials credentials = sd.getLoggedCredentials();
		Software software = ss.getSoftwareById(id);
		model.addAttribute("loggedUser", username);
		model.addAttribute("loggedCredentials", credentials);
		model.addAttribute("Software", software);
		
		return "softwarePage";
	}
	
}
