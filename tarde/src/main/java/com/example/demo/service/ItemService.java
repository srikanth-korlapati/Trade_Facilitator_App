//package com.example.demo.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.beans.Item;
//import com.example.demo.repository.ItemRepository;
//
//@Service
//public class ItemService {
//	
//	@Autowired
//	ItemRepository irepo;
//	
//	
//	public  List<Item> showItems(){
//		
//		List<Item> ilist = irepo.findAll();
//		return ilist;
//		
//	}
//	
//	public void addItem(Item item) {
//		
//		irepo.save(item);
//		
//	}
//	
//	public void updateItem(Item item) {
//		
//		irepo.save(item);
//		
//	}
//	
//	public void deleteItem(long id) {
//		
//		irepo.deleteById(id);
//		
//	}
//	
//	
//
//}
