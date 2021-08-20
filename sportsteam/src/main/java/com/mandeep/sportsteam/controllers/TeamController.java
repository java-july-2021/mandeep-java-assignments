package com.mandeep.sportsteam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandeep.sportsteam.models.Team;
import com.mandeep.sportsteam.services.TeamService;

@RestController
@RequestMapping("/api")
public class TeamController {
	@Autowired
	private TeamService tService;
	@GetMapping("")
	public List<Team> index(){
		return this.tService.getAll();
	}
	
	@PostMapping("/create")
	public Team createTeam(Team team) {
		return this.tService.create(team);
	}
	
	@GetMapping("/{id}")
	public Team getOneTeam(@PathVariable Long id) {
		return this.tService.getOne(id);
	}
	
	@DeleteMapping("/{id}/delete")
	public void delete(@PathVariable Long id) {
		this.tService.deleteById(id);
	}
	
	@PutMapping("/{id}/update")
	public Team update(@PathVariable Long id, Team team) {
		return this.tService.update(team);
	}
}
