package com.project.getshare.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.getshare.model.Software;
import com.project.getshare.model.SoftwareHouse;
import com.project.getshare.repository.SoftwareRepository;

@Service
public class SoftwareService {

	@Autowired
	protected SoftwareRepository softwareRepository;
	
	@Transactional
	public Software getSoftwareById(Long id) {
		Optional<Software> software = softwareRepository.findById(id);
		return software.orElse(null);
	}
	
	@Transactional
	public Software getSoftwareByName(String name) {
		Optional<Software> software = softwareRepository.findByName(name);
		return software.orElse(null);
	}
	
	@Transactional
	public Software saveSoftware(Software entity) {
		return softwareRepository.save(entity);
	}
	
	@Transactional
	public void deleteSoftware(Software entity) {
		softwareRepository.delete(entity);
	}
	
	@Transactional
	public List<Software> getAllSoftware(){
		List<Software> softwares = new ArrayList<Software>();
		Iterable<Software> allSoftware = this.softwareRepository.findAll();
		
		for(Software software : allSoftware) {
			softwares.add(software);
		}
		
		return softwares;
	}
	
	@Transactional
	public List<Software> getAllSoftwareBySoftwareHouse(SoftwareHouse softwarehouse){
		List<Software> softwares = new ArrayList<Software>();
		Iterable<Software> allSoftware = this.softwareRepository.findAllBySoftwarehouse(softwarehouse);
		
		for(Software software : allSoftware) {
			softwares.add(software);
		}
		
		return softwares;
	}
}
