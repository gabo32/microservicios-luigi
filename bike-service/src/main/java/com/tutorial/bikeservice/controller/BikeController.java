package com.tutorial.bikeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {

	@Autowired
	BikeService bikeService;
	
	@GetMapping 
	public ResponseEntity<List<Bike>> getAll(){
		List<Bike> bikes = bikeService.getAll();
		
		if( bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(bikes);
		}
	}
	
	@GetMapping("/byuser/{bikeId}")
	public ResponseEntity<List<Bike>> getByUserId(@PathVariable("bikeId") int bikeId){
		List<Bike> bikes = bikeService.byUserId(bikeId);
		
		if( bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(bikes);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike> getById(@PathVariable("id") int id){
		Bike car = bikeService.getUserById(id);
		
		if( car == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(car);
		}
	}
	
	@PostMapping
	public ResponseEntity<Bike> save(@RequestBody Bike bike){
		Bike bikeNew = bikeService.save(bike);
		
		return ResponseEntity.ok(bikeNew);
		
	}
}
