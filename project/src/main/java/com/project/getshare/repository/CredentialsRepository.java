package com.project.getshare.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.getshare.model.Credentials;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

	public Optional<Credentials> findByEmail(String email);
	
}
