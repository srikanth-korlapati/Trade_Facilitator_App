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

import com.example.demo.beans.Item;
import com.example.demo.repository.ItemRepository;
import com.example.exception.ResourceNotFoundExceprtion;

@RestController
public class ItemController {

	@Autowired
	ItemRepository irepo;
	
	@GetMapping("/getItems")
	public List<Item> getItems(){
		List<Item> ilist = irepo.findAll();
		return ilist;
	}
	
	@PostMapping("/addItem")
	public Item createItem(@RequestBody Item item) {
		return irepo.save(item);
	}
	
	@GetMapping("/getItem/{item_id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long item_id){
		Item item = irepo.findById(item_id)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + item_id));
		return ResponseEntity.ok(item);
	}
	
	@PutMapping("updateItem/{item_id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long item_id, @RequestBody Item itemDetails){
		Item item = irepo.findById(item_id)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + item_id));
		
		item.setItem_name(itemDetails.getItem_name());
		item.setPrice(itemDetails.getPrice());
		item.setQuantity(itemDetails.getQuantity());
		
		Item resItem = irepo.save(item);
		return ResponseEntity.ok(resItem);
		
	}
	
	@DeleteMapping("deleteItem/{item_id}")
	public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long item_id){
		Item item = irepo.findById(item_id)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + item_id));
		irepo.delete(item);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("increaseQuantity/{item_id}")
	public ResponseEntity<Item> increaseQuantity(@PathVariable Long item_id, @RequestBody Item itemDetails){
		Item item = irepo.findById(item_id)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + item_id));
		
		item.setQuantity(itemDetails.getQuantity()+item.getQuantity());
		
		Item resItem = irepo.save(item);
		return ResponseEntity.ok(resItem);
		
	}
	
	@PutMapping("decreaseQuantity/{item_id}")
	public ResponseEntity<Item> decreaseQuantity(@PathVariable Long item_id, @RequestBody Item itemDetails){
		Item item = irepo.findById(item_id)
				.orElseThrow(() -> new ResourceNotFoundExceprtion("User id not Found : " + item_id));
		
		item.setQuantity(item.getQuantity()-itemDetails.getQuantity());
		
		Item resItem = irepo.save(item);
		return ResponseEntity.ok(resItem);
		
	}
	
	
	
	
}
