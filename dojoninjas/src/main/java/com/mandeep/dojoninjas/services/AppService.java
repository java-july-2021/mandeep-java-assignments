package com.mandeep.dojoninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mandeep.dojoninjas.models.Dojo;
import com.mandeep.dojoninjas.models.Ninja;
import com.mandeep.dojoninjas.repositories.DojoRepository;
import com.mandeep.dojoninjas.repositories.NinjaRepository;

@Service
public class AppService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public AppService(DojoRepository dRepo, NinjaRepository nRepo) {
		this.dojoRepo = dRepo;
		this.ninjaRepo = nRepo;
	}
	public List<Dojo> allDojos() {
		return this.dojoRepo.findAll();
	}
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
