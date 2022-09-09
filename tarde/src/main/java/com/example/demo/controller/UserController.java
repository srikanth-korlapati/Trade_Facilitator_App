package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.User;
import com.example.demo.repository.UserRepository;
import com.example.exception.ResourceNotFoundExceprtion;

@RestController
public class UserController {

	@Autowired
	UserRepository urepo;
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		List<User> ulist = urepo.findAll();
		return ulist;
	}
	
	@PostMapping("/addUser")
	public Boolean createUser(@RequestBody User user) {
		String email = user.getEmail();
		List<User> ulist = urepo.findByEmail(email);
		if(ulist.size()==0) {
			urepo.save(user);
			return true;
		}
		return false;
	}
	
	
	@GetMapping("/getUser/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable Long uid){
		User user = urepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + uid));
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("updateUser/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable Long uid, @RequestBody User userDetails){
		
		User user = urepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + uid));
		
		user.setAddress(userDetails.getAddress());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setRole(userDetails.getRole());
		user.setUname(userDetails.getUname());
		
		User resUser = urepo.save(user);
		return ResponseEntity.ok(resUser);
		
	}
	
	@DeleteMapping("deleteUser/{uid}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long uid){
		
		User user = urepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + uid));
		urepo.delete(user);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("check/{email}/{password}")
	public String checkUser(@PathVariable String email, @PathVariable String password){
		List<User> user = urepo.findDistinctByEmailAndPassword(email, password);
		if(user.size() > 0) {
			return user.get(0).getRole();
		}
		return "User Not Found";
		
	}
	
	@PostMapping("/signUp")
	public Boolean SignUp(@RequestBody User user) {
		String email = user.getEmail();
		List<User> ulist = urepo.findByEmail(email);
		if(ulist.size() == 0) {
			urepo.save(user);
			return true;
		}
		return false;
	}
	
	
}



