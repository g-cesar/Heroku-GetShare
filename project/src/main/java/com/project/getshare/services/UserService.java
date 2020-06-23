package com.project.getshare.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.getshare.model.Cart;
import com.project.getshare.model.SoftwareHouse;
import com.project.getshare.model.User;
import com.project.getshare.repository.CartRepository;
import com.project.getshare.repository.SoftwareHouseRepository;
import com.project.getshare.repository.UserRepository;

@Service
public class UserService {

	public UserService() {
		
	}
	
	@Autowired
	protected UserRepository ur;
	
	@Autowired
	protected CartRepository cr;
	
	@Autowired
	protected SoftwareHouseRepository softwarehouseRepository;
	
	@Transactional
	public User getUser(Long id) {
		Optional<User> result = this.ur.findById(id);
		return result.orElse(null);
	}
	
	@Transactional
	public User saveUser(User user) {
		return this.ur.save(user);
	}
	
	@Transactional
	public User saveUser(User user, Cart cart) {
		this.cr.save(cart);
		user.setCart(cart);
		return this.ur.save(user);
	}
	
	@Transactional
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		Iterable<User> allUsers = this.ur.findAll();
		
		for(User user : allUsers) {
			users.add(user);
		}
		
		return users;
	}
	
	@Transactional
	public List<SoftwareHouse> getAllSoftwarehouse() {
		List<SoftwareHouse> softwarehouses = new ArrayList<SoftwareHouse>();
		Iterable<SoftwareHouse> allSoftwarehouses = this.softwarehouseRepository.findAll();
		
		for(SoftwareHouse softwarehouse : allSoftwarehouses) {
			softwarehouses.add(softwarehouse);
		}
		
		return softwarehouses;
	}
}
