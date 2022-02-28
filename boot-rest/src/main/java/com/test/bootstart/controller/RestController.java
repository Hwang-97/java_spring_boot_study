package com.test.bootstart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {
	
	@GetMapping("/list")
	public List<String> list(){
		
		List<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("귤");
		list.add("오렌지");
		
		return list;
	}

}
