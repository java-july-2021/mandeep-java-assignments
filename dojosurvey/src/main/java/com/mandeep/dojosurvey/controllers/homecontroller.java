package com.mandeep.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homecontroller {
	private String[] getLocations() {
		return new String[] {
			"Dallas","San jose","Seattle"	
		};	
	}
	
	private String[] getLanguages() {
		return new String[] {
				"java","Python","c#"	
		};
	}
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("locations",getLocations());
		viewModel.addAttribute("languages",getLanguages());
		return "index.jsp";
	}
	
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String Results(@RequestParam(value="name") String name,@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,@RequestParam(value="comment") String comment,
			Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("language", language);
		viewModel.addAttribute("comment", comment);
		return "survey.jsp";
	}

}
