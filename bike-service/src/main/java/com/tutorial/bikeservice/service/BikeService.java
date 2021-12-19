package com.tutorial.bikeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.repository.BikeRepository;

@Service
public class BikeService {

	@Autowired
	BikeRepository bikeRepository;
	
	public List<Bike> getAll(){
		return bikeRepository.findAll();
	}
	
	public Bike getUserById(int id) {
		return bikeRepository.findById(id).orElse(null);
	}
	
	public Bike save(Bike bike) {
		Bike carNew = bikeRepository.save(bike);
		
		return carNew;
	}
	
	public List<Bike> byUserId(int userId){
		return bikeRepository.findByUserId(userId);
	}
}
