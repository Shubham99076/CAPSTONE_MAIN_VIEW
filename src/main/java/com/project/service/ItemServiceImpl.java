package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.data.model.ItemInfo;
import com.project.data.repository.ItemRepository;

@Component
public class ItemServiceImpl implements ItemService {
	
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<ItemInfo> allItems() {
		// TODO Auto-generated method stub
		System.out.println(itemRepository.findAll());
		 return itemRepository.findAll();
		
	}

}
