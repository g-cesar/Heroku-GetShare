package com.project.getshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.getshare.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
	
}
