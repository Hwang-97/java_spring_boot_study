package com.test.bootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.bootmybatis.repository.AddressDAO;

@Controller
public class MyBatisController {
	
	//필드 의존 주입
	//@Autowired
	//private AddressDAO dao;
	
	//생성자 의존 주입
	private AddressDAO dao;
	
	@Autowired
	public MyBatisController(AddressDAO dao) {
		//중간 개입
		this.dao = dao;
	}
	

	@GetMapping("/test")
	public String test() {
		
		return "test";
	}
	
	
	@GetMapping("/add") 
	public String add() {
		
		return "add";
	}
	
	
}

















