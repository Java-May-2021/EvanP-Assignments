package com.evan.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evan.languages.models.Language;
import com.evan.languages.repositories.languageRepository;

@Service

public class languageService {
	private final languageRepository lrepo;
	
	public languageService(languageRepository repo) {
		this.lrepo = repo;
	}
	
	public List<Language> allLanguages() {
		return this.lrepo.findAll();
	}
	
	public Language findLanguage(Long id) {
		return this.lrepo.findById(id).orElse(null);
	}
	public Language createLanguage(Language newLang) {
		return this.lrepo.save(newLang);		
	}
	
	public Language updateLanguage(Language updatedLang) {
		return this.lrepo.save(updatedLang);
	}
	
	public void deleteLanguage(Long id) {
		this.lrepo.deleteById(id);
	}
}
