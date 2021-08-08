package com.mandeep.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandeep.dojoninjas.models.Dojo;
import com.mandeep.dojoninjas.services.AppService;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	private final AppService appService;
	public DojoController(AppService service) {
		this.appService = service;
	}
	@GetMapping("/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	@PostMapping("/createDojo")
	public String dojoCreate(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}
		this.appService.createDojo(dojo);
		return "redirect:/ninja/new";
	}
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.appService.findDojo(id));
		return "dojodetail.jsp";
	}
}
