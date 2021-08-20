package com.mandeep.sportsteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandeep.sportsteam.models.Player;
import com.mandeep.sportsteam.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository pRepo;
	
	public Player createPlayer(Player player) {
		return this.pRepo.save(player);
	}
}
