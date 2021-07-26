package com.mandeep.guesscode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class homecontroller {
	private Boolean correctCode(String guess) {
		return guess.equals("bushido");
	}
	
	private String[] getTenets() {
		return new String[] {
				"Loyalty", "Courage", "Veracity", "Compassion", "Honor"
		};

	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/attempt", method=RequestMethod.POST)
	public String Attempt(@RequestParam(value="guess") String guess, Model viewModel,
			RedirectAttributes rAttributes) {
		if(correctCode(guess)) {
			return "redirect:/code";
		}
		rAttributes.addFlashAttribute("error","You must train harder!");
		return "redirect:/";
			
	}
	@RequestMapping("/code")
	public String code(Model viewModel) {
		viewModel.addAttribute("tenets", getTenets());
		return "code.jsp";
	}

}
