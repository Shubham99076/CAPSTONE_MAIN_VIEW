package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.data.model.ItemInfo;
import com.project.data.model.UserInfo;

@Service
public interface ItemService  {
	
	List<ItemInfo> allItems();

	
	

}
