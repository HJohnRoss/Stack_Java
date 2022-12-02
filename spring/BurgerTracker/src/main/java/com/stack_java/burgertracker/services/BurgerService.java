package com.stack_java.burgertracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stack_java.burgertracker.models.Burger;
import com.stack_java.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
