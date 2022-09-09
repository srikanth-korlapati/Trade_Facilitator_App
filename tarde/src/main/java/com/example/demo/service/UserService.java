//package com.example.demo.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.beans.User;
//import com.example.demo.repository.UserRepository;
//
//@Service
//public class UserService {
//
//	@Autowired
//	UserRepository urepo;
//	
//	
//	public List<User> findUsers() {
//		// TODO Auto-generated method stub
//		List<User> ulist = urepo.findAll();
//		return ulist;
//	}
//
//	public void addUser(User user) {
//		// TODO Auto-generated method stub
//		urepo.save(user);
//		
//	}
//
//	public void updateUser(User user) {
//		// TODO Auto-generated method stub
//		urepo.save(user);
//		
//	}
//
//	public void deleteUser(long uid) {
//		// TODO Auto-generated method stub
//		urepo.deleteById(uid);
//		
//	}
//
//}
