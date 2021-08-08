package com.mandeep.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandeep.dojoninjas.models.Ninja;
import com.mandeep.dojoninjas.services.AppService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
	private AppService appService;
	public NinjaController(AppService service) {
		this.appService = service;
	}
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.appService.allDojos());
		return "newninja.jsp";
	}
	@PostMapping("/createNinja")
	public String Create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.appService.allDojos());
			return "newninja.jsp";
		}
		this.appService.createNinja(ninja);
		return "redirect:/dojo/new";
	}
}
