package com.test.thymeleaf.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.thymeleaf.domain.AddressDTO;
import com.test.thymeleaf.repository.IAddressDAO;

@Controller
public class TestController {

	private IAddressDAO dao;

	@Autowired
	public TestController(IAddressDAO dao) {
		this.dao = dao;
	}

	@GetMapping("/test")
	public String test(Model model) {

		model.addAttribute("num", 100);

		return "test"; // resources > templates > test.html
	}



	@GetMapping("/ex01")
	public String ex01(Model model, HttpSession session) {
		
		//단일값
		int num = dao.num();
		model.addAttribute("num", num);
		
		String name = dao.name(10);
		model.addAttribute("name", name);
		
		model.addAttribute("now", Calendar.getInstance());
		model.addAttribute("n", 123456789);
		
		model.addAttribute("logo", "<i>Spring Thymeleaf</i>");
		
		//단일값(복합값)
		AddressDTO dto = dao.get(10);
		model.addAttribute("dto", dto);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		map.put("white", "하양");
		map.put("black", "검정");
		model.addAttribute("map", map);
		
		//다중값
		List<String> fruit = Arrays.asList("사과", "딸기", "바나나", "귤", "포도");
		model.addAttribute("fruit", fruit);
		
		List<AddressDTO> list = dao.list();
		model.addAttribute("list", list);
		
		
		session.setAttribute("id", "hong");
		session.setAttribute("name", "홍길동");
		
		return "test";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model, AddressDTO dto) {
		
		model.addAttribute("dto", dto);
		
		return "ex02";
	}
	
	@GetMapping("/ex03/{color}")
	public String ex03(Model model, @PathVariable("color") String color) {
		
		System.out.println(color);
		
		model.addAttribute("color", color);
		
		return "ex03";
	}
	
	
}
























