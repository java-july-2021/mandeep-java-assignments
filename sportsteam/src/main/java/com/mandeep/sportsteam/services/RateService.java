package com.mandeep.sportsteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandeep.sportsteam.models.Rate;
import com.mandeep.sportsteam.repositories.RateRepository;

@Service
public class RateService {
	@Autowired
	private RateRepository rRepo;
	
	public Rate createRating(Rate rate) {
		return this.rRepo.save(rate);
	}
}
