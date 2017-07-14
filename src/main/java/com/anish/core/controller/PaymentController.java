package com.anish.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class PaymentController {
	
	@RequestMapping("account")
	public String account(){
		
		return "Payment";
	}
	
	
}
