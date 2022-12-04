package com.stack_java.relationships.services;

import org.springframework.stereotype.Service;

import com.stack_java.relationships.models.License;
import com.stack_java.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	LicenseService(LicenseRepository licenseRepository){
		this.licenseRepository = licenseRepository;
	}
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
}
