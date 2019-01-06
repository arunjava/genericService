package com.gservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gservice.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
		
}
