package com.mandeep.springfundamentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class homecontroller {
	@RequestMapping("/")
	private String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/random")
	private String random() {
		return "random.jsp";
	}
}
