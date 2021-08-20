package com.mandeep.sportsteam.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mandeep.sportsteam.models.Player;
import com.mandeep.sportsteam.models.Rate;
import com.mandeep.sportsteam.models.Team;
import com.mandeep.sportsteam.models.User;
import com.mandeep.sportsteam.services.PlayerService;
import com.mandeep.sportsteam.services.RateService;
import com.mandeep.sportsteam.services.TeamService;
import com.mandeep.sportsteam.services.UserService;
import com.mandeep.sportsteam.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private TeamService tService;
	@Autowired
	private PlayerService pService;
	@Autowired
	private UserService uService;
	@Autowired
	private RateService rService;
	@Autowired
	private UserValidator validator;
	
	public void setSessionSettings(HttpSession session) {
		session.setMaxInactiveInterval(-1);
	}
	
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user, HttpSession session) {
		setSessionSettings(session);
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user___id", newUser.getId());
		return "redirect:/dashboard";
	}
	@PostMapping("/login")
	public String loggingIn(@RequestParam("loginemail") String email, @RequestParam("loginpassword") String password, HttpSession session, RedirectAttributes redirectAttr) {
		if(!this.uService.authenicateUser(email, password)) {
			redirectAttr.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user___id", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttr) {
		redirectAttr.addFlashAttribute("message", "You have been successfully logged Out!");
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		if(session.getAttribute("user___id") == null) {
			redirectAttr.addFlashAttribute("message", "You are not slick..... Login");
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user___id");
		List<Team> allTheTeams = this.tService.getAll();
		viewModel.addAttribute("allTeams", allTheTeams);
		viewModel.addAttribute("user", this.uService.getOneUser(userId));
		return "index.jsp";
	}
	
	@GetMapping("/like/{id}")
	public String likeTeam(HttpSession session, @PathVariable("id") Long teamId) {
		Long userId = (Long)session.getAttribute("user___id");
		User userToLike = this.uService.getOneUser(userId);
		Team teamToLike = this.tService.getOne(teamId);
		this.tService.likeTeam(teamToLike, userToLike);
		return "redirect:/dashboard";
	}

	@GetMapping("/unlike/{id}")
	public String unlikeTeam(HttpSession session, @PathVariable("id") Long teamId) {
		Long userId = (Long)session.getAttribute("user___id");
		User userToLike = this.uService.getOneUser(userId);
		Team teamToLike = this.tService.getOne(teamId);
		this.tService.unlikeTeam(teamToLike, userToLike);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/rate/{id}")
	public String rateTeam(HttpSession session, @PathVariable("id") Long teamId, @RequestParam("rating") Double rating) {
		Long userId = (Long)session.getAttribute("user___id");
		User userToRate = this.uService.getOneUser((userId);
		Team teamToRate = this.tService.getOne(teamId);
		Rate newRating = new Rate(rating, teamToRate, userToRate);
		this.rService.createRating(newRating);
		return "redirect:/{id}";
	}
	
	@GetMapping("/new")
	public String newTeam(@ModelAttribute("team") Team team, HttpSession session, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user___id")));
		return "new.jsp";
	}
    
	@PostMapping("/addTeam")
	public String addTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		User teamOwner = this.uService.getOneUser((Long)session.getAttribute("user___id"));
		team.setOwner(teamOwner);
		this.tService.create(team);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String displayTeams(@PathVariable("id") Long id, Model viewModel) {
		Team teamToDisplay = this.tService.getOne(id);
		viewModel.addAttribute("team", teamToDisplay);
		return "show.jsp";
	}
	
	@GetMapping("/player/new")
	public String newPlayer(Model viewModel, @ModelAttribute("player") Player player) {
		List<Team> allTeams = this.tService.getAll();
		viewModel.addAttribute("allTeams", allTeams);
	    return "player/new.jsp";	
	}
	
	@PostMapping("/newPlayer")
	public String addPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Team> allTeams = this.tService.getAll();
			viewModel.addAttribute("allTeams", allTeams);
			
		}
		this.pService.createPlayer(player);
		Long teamsId = player.getTeam().getId();
		return "redirect:/" + teamsId;	
	}
	
	@GetMapping("/edit/{id}")
	public String editPlayer(@PathVariable("id") Long id, @ModelAttribute("team") Team team, Model viewModel) {
		viewModel.addAttribute("team", this.tService.getOne(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("team") Team team, BindingResult result, Model viewModel, @PathVariable("id") Long id, HttpSession session ) {
		if(result.hasErrors()) {
			viewModel.addAttribute("team", this.tService.getOne(id));
			return "edit.jsp";
		}
		User teamOwner = this.uService.getOneUser((Long)session.getAttribute("user___id"));
		team.setOwner(teamOwner);
		this.tService.update(team);
		return "redirect:/" + id;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.tService.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/profile/{id}")
	public String userProfile(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "profile.jsp";
	}
}

