package com.project.getshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.getshare.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
