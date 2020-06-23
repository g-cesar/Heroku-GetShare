package com.project.getshare.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.getshare.model.SoftwareHouse;
import com.project.getshare.repository.SoftwareHouseRepository;
import com.project.getshare.repository.UserRepository;

@Service
public class SoftwareHouseService {

	@Autowired
	protected SoftwareHouseRepository softwarehouseRepository;
	
	@Autowired
	protected UserRepository userRepository;
	
	@Transactional
	public Boolean alreadyExists(SoftwareHouse softwarehouse) {
		if(softwarehouse.getName()==null) {
			return false;
		}
		else if(this.softwarehouseRepository.findByName(softwarehouse.getName())==null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Transactional
	public SoftwareHouse getSoftwareHouseById(Long id) {
		Optional<SoftwareHouse> softwarehouse = softwarehouseRepository.findById(id);
		return softwarehouse.orElse(null);
	}
	
	@Transactional
	public SoftwareHouse getSoftwareHouseByName(String name) {
		Optional<SoftwareHouse> softwarehouse = softwarehouseRepository.findByName(name);
		return softwarehouse.orElse(null);
	}

	@Transactional
	public SoftwareHouse getSoftwarehouseByUserId(Long id){
		Optional<SoftwareHouse> softwarehouse = softwarehouseRepository.findByUser_id(id);
		return softwarehouse.orElse(null);
	}
	
	@Transactional
	public List<SoftwareHouse> getAllSoftwarehouseByUserId(Long id){
		List<SoftwareHouse> softwarehouses = new ArrayList<SoftwareHouse>();
		Iterable<SoftwareHouse> allsoftwarehouses = this.softwarehouseRepository.findAll();
		
		for(SoftwareHouse softwarehouse : allsoftwarehouses) {
			if(softwarehouse.getUser().getId() == id)
				softwarehouses.add(softwarehouse);
		}
		
		return softwarehouses;
	}
	
	@Transactional
	public SoftwareHouse saveSoftwareHouse(SoftwareHouse entity) {
		return softwarehouseRepository.save(entity);
	}
	
	@Transactional
	public void deleteSoftwareHouse(SoftwareHouse entity) {
		softwarehouseRepository.delete(entity);
	}

	public List<SoftwareHouse> getAllSoftwarehouse() {
		List<SoftwareHouse> softwarehouses = new ArrayList<SoftwareHouse>();
		Iterable<SoftwareHouse> allsoftwarehouses = this.softwarehouseRepository.findAll();
		
		for(SoftwareHouse softwarehouse : allsoftwarehouses) {
			softwarehouses.add(softwarehouse);
		}
		
		return softwarehouses;
	}
	
}
