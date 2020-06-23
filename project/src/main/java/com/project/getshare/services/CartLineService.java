package com.project.getshare.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.getshare.model.CartLine;
import com.project.getshare.repository.CartLineRepository;

@Service
public class CartLineService {
	
	@Autowired
	protected CartLineRepository cartlineRepository;
	
	@Transactional
	public CartLine getCartLineById(Long id) {
		Optional<CartLine> cartline = cartlineRepository.findById(id);
		return cartline.orElse(null);
	}
	
	@Transactional
	public CartLine saveCartLine(CartLine entity) {
		return cartlineRepository.save(entity);
	}
	
	@Transactional
	public void deleteCartLine(CartLine entity) {
		cartlineRepository.delete(entity);
	}
	
}
