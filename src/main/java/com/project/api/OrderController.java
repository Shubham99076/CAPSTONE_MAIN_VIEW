package com.project.api;

import static com.project.util.Route.USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.map.HashedMap;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.project.config.DbConfig;
import com.project.data.model.InvoiceInfo;
import com.project.data.model.ItemInfo;
import com.project.data.model.OrderInfo;
import com.project.data.model.PurchaseOrderInfo;
import com.project.data.model.UserInfo;
import com.project.service.InvoiceService;
import com.project.service.OrderService;
import com.project.service.POService;
import com.project.util.MyMessage;

@Controller
@RequestMapping(USER)
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired 
	POService poService;
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String mail_url="http://localhost:9002/send";
	
	@GetMapping("/create-order")
	public ModelAndView userManagementView() {
		ModelAndView mv = new ModelAndView("create_order");
		return mv;
	}
	
	
	@GetMapping("/purchase-order/{orderid}/{poid}")
	public ModelAndView confirm_place_order(@PathVariable Integer orderid,@PathVariable Integer poid) {
		ModelAndView mv = new ModelAndView("confirm_place_order");
		System.out.println(poid);
		System.out.println(orderid);
		
//		Map<String,Integer> maps=new HashedMap<String, Integer>();
	
		mv.addObject("confirm_place_po_id", poid);
		mv.addObject("confirm_place_order_id", orderid);
		
		
//		mv.addAllObjects(maps);
		System.out.println(mv);
//		mv.addObject("confirm_place_order_id", orderid);
		
		return mv;
	}
	
	@PostMapping("/confirm-po-order")
	public ModelAndView confirm(@ModelAttribute PurchaseOrderInfo po) {
		System.out.println(po.getPo_status());
		System.out.println(po.getPoid());
		System.out.println(po.getOrderid());
		ModelAndView mv = new ModelAndView();
		
		
		po.setCreatedAt(new Date());
		po.setUpdatedAt(new Date());
		po.setPoid(po.getPoid());
		
		poService.updatePO(po);
		InvoiceInfo inv=new InvoiceInfo();
		Integer new_order_id=0;
		
		Optional<PurchaseOrderInfo>ps=poService.findOrderId(po.getPoid());
		PurchaseOrderInfo new_ps=ps.get();
			Long oid=new_ps.getOrderid().getOrderid();
			Optional<OrderInfo>orderinfo1=orderService.findOrderId(new_ps.getOrderid().getOrderid());
OrderInfo new_ord=orderinfo1.get();
		
		inv.setAmount(new_ord.getPrice());
		inv.setDescription("Invoice Created");
		inv.setPaid_amount(0);
		inv.setRemaing_amount(0);
		inv.setPayment_status("Pending");
		inv.setQuantity(new_ord.getQty());
		inv.setCreatedAt(new Date());
		inv.setUpdatedAt(new Date());
		inv.setPoid(po);
		invoiceService.addInvoice(inv);
mv.setViewName("redirect:/user/pay-amount/"+po.getPoid()+"");
//		mv.addObject("pay-amount", po.getPoid());
		return mv;
		
	}
	
	@GetMapping("/pay-amount/{poid}")
	public ModelAndView payAmount(@PathVariable Long poid) {
		ModelAndView mv=new ModelAndView();
		
		Optional<InvoiceInfo>orderinfo1=invoiceService.findOrderId(poid);
		InvoiceInfo invs=orderinfo1.get();
		if(invs.getAmount()==invs.getPaid_amount()) {
			 mv = new ModelAndView("thanks");
		} else {
			mv = new ModelAndView("pay_amount");
			mv.addObject("pay_amount", invs);	
		}
		
		
		return mv;
	}
	
	@PostMapping("/payout")
	public ModelAndView payOut(@ModelAttribute InvoiceInfo invoiceInfo) {

		ModelAndView view = new ModelAndView("thanks");
		invoiceInfo.setPaid_amount(invoiceInfo.getPaid_amount());
		invoiceInfo.setDescription("Payment is Done");
		invoiceInfo.setPayment_status("Success");
		invoiceInfo.setInvoiceid(invoiceInfo.getInvoiceid());
		invoiceInfo.setQuantity(invoiceInfo.getQuantity());
		invoiceInfo.setAmount(invoiceInfo.getAmount());
		invoiceInfo.setRemaing_amount(invoiceInfo.getRemaing_amount());
		invoiceInfo.setPoid(invoiceInfo.getPoid());
		invoiceInfo.setCreatedAt(new Date());
		invoiceInfo.setUpdatedAt(new Date());
		invoiceService.updatePayment(invoiceInfo);
		
		Optional<PurchaseOrderInfo>ps=poService.findOrderId(invoiceInfo.getPoid().getPoid());
		PurchaseOrderInfo new_ps=ps.get();
			Long oid=new_ps.getOrderid().getOrderid();
			Optional<OrderInfo>orderinfo1=orderService.findOrderId(new_ps.getOrderid().getOrderid());
OrderInfo new_ord=orderinfo1.get();	
		
		
		MyMessage myMessage=new MyMessage(new_ord.getCust_email(),"<html><head></head><body><h4>Your Payment is Succefully done! </h4><br/> <p>Thank you for purchase this order </p> </body</html>");
	
		this.restTemplate.postForEntity(mail_url, myMessage, null);
		
		return view;
	}
	
	
	@PostMapping("/place-order")
	public ModelAndView placeOrder(@ModelAttribute OrderInfo orderInfo) {

		ModelAndView view = new ModelAndView("redirect:/user/showorder");
		orderInfo.setCreatedAt(new Date());
		orderInfo.setUpdatedAt(new Date());

		orderService.createOrder(orderInfo);
		PurchaseOrderInfo po=new PurchaseOrderInfo();
		po.setCreatedAt(new Date());
		po.setUpdatedAt(new Date());
		po.setOrderid(orderInfo);
		po.setPo_status("Placed Order");
		poService.createPO(po);
		
		MyMessage myMessage=new MyMessage(orderInfo.getCust_email(),"<html><head></head><body><h4>Your Order is Placed Succefully:! </h4><br/> <p>Please Confimed Purchase Order below Link </p> <a href='http://localhost:8080/user/purchase-order/"+orderInfo.getOrderid()+"/"+po.getPoid()+"'>Confirm Order</a></body</html>");
	
		this.restTemplate.postForEntity(mail_url, myMessage, null);
		
		return view;
	}
	
	@GetMapping("/showorder")
	public ModelAndView DisplayALlOrder() {
		ModelAndView mv = new ModelAndView("show_order");	
		mv.addObject("show_order", orderService.allOrder());		
		return mv;
	}
	
	@GetMapping("/show-po-order")
	public ModelAndView DisplayAllPOOrder() {
		ModelAndView mv = new ModelAndView("show_po");	
		mv.addObject("show_poorder", poService.allPoOrder());		
		return mv;
	}
	
	
	@GetMapping("/show-invoice")
	public ModelAndView DisplayAllInvoice() {
		ModelAndView mv = new ModelAndView("show_invoice");	
		mv.addObject("show_invoice", invoiceService.allInvoice());		
		return mv;
	}
	
	
	@GetMapping("/show-all-reports")
	public ModelAndView showReports() {
		ModelAndView mv = new ModelAndView("show_all_reports");				
		return mv;
	}
	
	
	
//	public InvoiceInfo findOrder(Integer poid) {
//		
//		try {
//			
//            Connection conn=DbConfig.getConnection();
//            String s="select distinct(category_name) from item";
//          PreparedStatement ps=conn.prepareStatement(s);
//        ResultSet rs=  ps.executeQuery();
//        ItemInfo items=new ItemInfo();
//       
//        while(rs.next()) {
//       
//       		JSONObject jsonObject=new JSONObject();
//       	
//       	 jsonObject.put("category_name", rs.getString("category_name"));
//       	 jsonArray.put(jsonObject);
//       
//        }
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//
//	}
//		
//		return null;
//	}
	


}
