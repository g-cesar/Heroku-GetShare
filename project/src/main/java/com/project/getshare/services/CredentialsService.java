package com.project.getshare.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.getshare.model.Credentials;
import com.project.getshare.model.User;
import com.project.getshare.repository.CredentialsRepository;

@Service
public class CredentialsService {

	@Autowired
	protected CredentialsRepository credentialRepository;
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Transactional
	public Credentials getCredentials(Long id) {
		Optional<Credentials> result = this.credentialRepository.findById(id);
		return result.orElse(null);
	}
	
	@Transactional
	public Credentials getCredentials(String email) {
		Optional<Credentials> result = this.credentialRepository.findByEmail(email);
		return result.orElse(null);
	}
	
	@Transactional
	public Credentials saveCredentials(Credentials credentials) {
		credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
		return this.credentialRepository.save(credentials);
	}
	
	@Transactional
	public void delete(Credentials credentials) {
		this.credentialRepository.delete(credentials);
	}
	
	@Transactional
	public User getUserByEmail(String email) {
		return this.credentialRepository.findByEmail(email).get().getUser();
	}
}
