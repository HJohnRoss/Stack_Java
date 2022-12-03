package com.stack_java.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stack_java.languages.models.Language;
import com.stack_java.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}

	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> oneLanguage = languageRepository.findById(id);
		if(oneLanguage != null) {
			return oneLanguage.get();
		} else {
			return null;
		}
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
