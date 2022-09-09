package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findDistinctByEmailAndPassword(String email, String password);
	
	List<User> findByEmail(String email);
	
	
}
