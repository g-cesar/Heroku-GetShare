package com.project.getshare.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.getshare.model.SoftwareHouse;

@Repository
public interface SoftwareHouseRepository extends CrudRepository<SoftwareHouse, Long> {

	public Optional<SoftwareHouse> findByName(String name);
	public Optional<SoftwareHouse> findByFoundation(String foundation);
	public Optional<SoftwareHouse> findByUser_id(Long id);
	
}
