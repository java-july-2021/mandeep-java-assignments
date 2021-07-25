package com.mandeep.displaydatetime.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model viewModel) {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, 'the' dd 'of' MMMM, YYYY");
		System.out.println(formatter.format(dt));
		viewModel.addAttribute("currentDate", formatter.format(dt));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model viewModel) {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m a");
		System.out.println(formatter.format(time));
		viewModel.addAttribute("currentTime", formatter.format(time));
		return "time.jsp";
	}
}
