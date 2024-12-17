package com.simplilearn.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	@Autowired
	private CarRepo repo;
	
	public CarEntity addUser(CarEntity u) {
		return repo.save(u);
	}
	
	
	public List<CarEntity> getAllcars(){
		return repo.findAll();
	}
	
	
	public CarEntity getCarbyid(int id) {
		if(repo.findById(id).isPresent())  
			return repo.findById(id).get();
		else
			return null;
	}
	
	
	public boolean deleteCar(int id) {
		
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	//update by id
	
		public CarEntity updateUser(CarEntity car,int id) {
			if(repo.findById(id).isPresent()) {
				CarEntity old= repo.findById(id).get();
				old.setCarName(car.getCarName());
				old.setArrival(car.getArrival());
				old.setDestination(car.getDestination());;
				
				return repo.save(old);
			}else {
				return null;
			}
		}
	

}
