package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	
	
	@RequestMapping("/index")
	public String indexPage() {
		
		return"index";
		
	}

	@RequestMapping("/news")
	public String newsPage() {
		
		return"news";
	}
	
	
	@RequestMapping("/news1")
	public String news1Page() {
		
		return"news1";
	}
	
	
	@RequestMapping("/news2")
	public String news2Page() {
		
		return"news2";
	}

	@RequestMapping("/creditcard")
	public String creditcardPage() {
		
		return"creditcard";
	}
	
}
