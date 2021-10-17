package com.project.api;

import static com.project.util.Route.USER;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.project.data.model.ReportInfo;

@Controller
@RequestMapping(USER)
public class ReportController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String mail_url="http://localhost:9002/send";
	
	@GetMapping("/show-total-amount")
	public ModelAndView showTotalAmount() {
		ModelAndView mv = new ModelAndView("show_total_amount");
		ReportInfo r=this.restTemplate.getForObject("http://localhost:9004/report/total_balance",ReportInfo.class);
		System.out.println(r.getTotal_amount());
		mv.addObject("total_amount", r.getTotal_amount());
		mv.addObject("remaining_amount", r.getRemaing_amount());
		mv.addObject("paid_amount", r.getRecieving_amount());
		return mv;
	}
	
	
	@GetMapping("/show-cust-invoice")
	public ModelAndView findInvoiceByCustomer() {
		ModelAndView mv = new ModelAndView("find_cust_invoice");
		return mv;
	}
	
	@GetMapping("/show-cust-po")
	public ModelAndView findPoByCustomer() {
		ModelAndView mv = new ModelAndView("find_cust_po");
		return mv;
	}
	
	
	
	@GetMapping("/find-invoice")
	public ModelAndView findInvoiceByCustomerBacks(@RequestParam("cust_data") String cust_data) {
		ModelAndView mv = new ModelAndView("show_cust_invoice");
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:9004/report/cust-invoice/"+cust_data+"", Object[].class);
		Object[] objects = responseEntity.getBody();		
		System.out.println(objects);
		mv.addObject("cust_invoice", objects);

		return mv;
	}
	
	@GetMapping("/find-po")
	public ModelAndView findPOByCustomerBacks(@RequestParam("cust_data") String cust_data) {
		ModelAndView mv = new ModelAndView("show_cust_po");
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:9004/report/cust-po/"+cust_data+"", Object[].class);
		Object[] objects = responseEntity.getBody();		
		System.out.println(objects);
		mv.addObject("cust_po", objects);

		return mv;
	}
	


}
