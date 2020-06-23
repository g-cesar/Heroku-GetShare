package com.project.getshare.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.getshare.model.Cart;
import com.project.getshare.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	protected CartRepository cartRepository;
	
	@Transactional
	public Cart getCartById(Long id) {
		Optional<Cart> cart = cartRepository.findById(id);
		return cart.orElse(null);
	}
	
	@Transactional
	public Cart saveCart(Cart entity) {
		return cartRepository.save(entity);
	}
	
	@Transactional
	public void deleteCart(Cart entity) {
		cartRepository.delete(entity);
	}
	
}
