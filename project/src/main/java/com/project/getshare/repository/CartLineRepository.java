package com.project.getshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.getshare.model.CartLine;

@Repository
public interface CartLineRepository extends CrudRepository<CartLine, Long> {

}
