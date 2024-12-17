package com.simplilearn.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String CarName;
	private String Destination;
	private String Arrival;
	private String Qnty;
	
	public CarEntity() {
		
	}

	public CarEntity(int id, String carName, String destination, String arrival, String qnty) {
		super();
		this.id = id;
		CarName = carName;
		Destination = destination;
		Arrival = arrival;
		Qnty = qnty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarName() {
		return CarName;
	}

	public void setCarName(String carName) {
		CarName = carName;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getArrival() {
		return Arrival;
	}

	public void setArrival(String arrival) {
		Arrival = arrival;
	}

	public String getQnty() {
		return Qnty;
	}

	public void setQnty(String qnty) {
		Qnty = qnty;
	}

	@Override
	public String toString() {
		return "CarEntity [id=" + id + ", CarName=" + CarName + ", Destination=" + Destination + ", Arrival=" + Arrival
				+ ", Qnty=" + Qnty + "]";
	}
	
	
	
	

}
