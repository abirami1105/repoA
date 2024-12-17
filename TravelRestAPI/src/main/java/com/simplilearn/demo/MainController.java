package com.simplilearn.demo;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class MainController {
	
	@Autowired
	private CarService service;
	
	 
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public ResponseEntity<CarEntity> addUser(CarEntity u){
		CarEntity car= service.addUser(u);
		if(car!=null)
			return new ResponseEntity<CarEntity>(car,HttpStatus.CREATED);
		else
			return new ResponseEntity<CarEntity>(car, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//@GetMapping("/")
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public  List<CarEntity> getAllUsers(){
		return service.getAllcars();
	}
	
	//@GetMapping("/{id}")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public  ResponseEntity<CarEntity> getUserbyId(@PathVariable int id){
		CarEntity car= service.getCarbyid(id);
		
		if(car!=null) 
			return new ResponseEntity<CarEntity>(car,HttpStatus.FOUND);
		else
			return new ResponseEntity<CarEntity>(car,HttpStatus.NOT_FOUND);
	}
	
	//@DeleteMapping("/{id}")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCar(@PathVariable int id){
		if(service.deleteCar(id))
			return new ResponseEntity<Object>("User Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Found",HttpStatus.NOT_FOUND);
	}
	//@PutMapping("/{id}")
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@RequestBody CarEntity car,@PathVariable int id){
		CarEntity data=service.updateUser(car, id);
		
		if(data!=null)
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
	}

}
