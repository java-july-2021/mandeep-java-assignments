package com.mandeep.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mandeep.languages.models.language;
import com.mandeep.languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {
	private final LanguagesRepository langRepo;
	public LanguagesService(LanguagesRepository repo) {
		langRepo = repo;
	}
	
	public List<language> allLanguages() {
		return langRepo.findAll();
	}
	
	public language findLanguage(Long id) {
		return langRepo.findById(id).orElse(null);
	}
	public language createLanguage(language lang) {
		return langRepo.save(lang);
	}
	
	public language updateLanguage(language lang) {
		return langRepo.save(lang);
	}
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
