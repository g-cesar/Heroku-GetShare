package com.project.getshare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.getshare.model.Software;
import com.project.getshare.model.SoftwareHouse;

@Repository
public interface SoftwareRepository extends CrudRepository<Software, Long> {

	public Optional<Software> findById(Long id);
	
	public Optional<Software> findByName(String name);
	
	public List<Software> findAllBySoftwarehouse(SoftwareHouse softwarehouse);
	
	/*public Software addSoftwareToUser(Software software, User user) {
		software.addUser(user)
	}*/
	
}
