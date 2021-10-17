package com.project.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.config.DbConfig;
import com.project.data.model.ItemInfo;
import com.project.service.ItemService;


@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/showcategory")
	public String ShowAllCategory() {
		
		JSONArray jsonArray=new JSONArray();
	
		 List<ItemInfo> list=new ArrayList<ItemInfo>();
		try {
			
                 Connection conn=DbConfig.getConnection();
                 String s="select distinct(category_name) from item";
               PreparedStatement ps=conn.prepareStatement(s);
             ResultSet rs=  ps.executeQuery();
             ItemInfo items=new ItemInfo();
            
             while(rs.next()) {
            
            		JSONObject jsonObject=new JSONObject();
            	
            	 jsonObject.put("category_name", rs.getString("category_name"));
            	 jsonArray.put(jsonObject);
            
             }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		
		
		return jsonArray.toString();
		
	}
	
	
	
	@GetMapping("/showitem/{cat_name}")
	public String ShowAllItems(@PathVariable String cat_name) {
		System.out.println(cat_name);
		JSONArray jsonArray=new JSONArray();	
		
		try {
			
             Connection conn=DbConfig.getConnection();
             String s="select * from item where category_name='"+cat_name+"'";
             PreparedStatement ps=conn.prepareStatement(s);
             ResultSet rs=  ps.executeQuery();
             ItemInfo items=new ItemInfo();
            
             while(rs.next()) {
            	 
            	JSONObject jsonObject=new JSONObject();            	
            	 jsonObject.put("category_name", rs.getString("category_name"));
            	 jsonObject.put("item_name", rs.getString("item_name"));
            	 jsonObject.put("item_id", rs.getString("itemid"));
            	 jsonObject.put("price", rs.getString("price"));
            	 jsonObject.put("qty", rs.getString("qty"));
            	 jsonArray.put(jsonObject);
            
             }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		
		return jsonArray.toString();
		
	}
	
	
	@GetMapping("/itemprice/{item_id}")
	public String findPriceByItemId(@PathVariable String item_id) {
		System.out.println(item_id);
		JSONArray jsonArray=new JSONArray();	
		
		  JSONObject jsonObject=new JSONObject();   
		try {
			
             Connection conn=DbConfig.getConnection();
             String s="select * from item where item_name='"+item_id+"'";
             PreparedStatement ps=conn.prepareStatement(s);
             ResultSet rs=  ps.executeQuery();           
           
             if(rs.next()) {
            	 
            	         	
            	 jsonObject.put("category_name", rs.getString("category_name"));
            	 jsonObject.put("item_name", rs.getString("item_name"));
            	 jsonObject.put("item_id", rs.getString("itemid"));
            	 jsonObject.put("price", rs.getString("price"));
            	 jsonObject.put("qty", rs.getString("qty"));
            	 
            
             }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		System.out.println(jsonObject);

		
		return jsonObject.toString();
		
	}

}
