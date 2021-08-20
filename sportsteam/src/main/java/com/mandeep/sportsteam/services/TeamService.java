package com.mandeep.sportsteam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandeep.sportsteam.models.Team;
import com.mandeep.sportsteam.models.User;
import com.mandeep.sportsteam.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository tRepo;
	public List<Team> getAll(){
		return this.tRepo.findAll();
	}
	
	public Team create(Team team) {
		return this.tRepo.save(team);
	}
	
	public void deleteById(Long id) {
		this.tRepo.deleteById(id);
	}
	
	public Team update(Team team) {
		return this.tRepo.save(team);
	}
	
	public Team getOne(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	public void likeTeam(Team team, User user) {
		List<User> userWhoLiked = team.getLikers();
		userWhoLiked.add(user);
		this.tRepo.save(team);
	}
	
	public void unlikeTeam(Team team, User user) {
		List<User> userWhoLiked = team.getLikers();
		userWhoLiked.remove(user);
		this.tRepo.save(team);
	}
}
