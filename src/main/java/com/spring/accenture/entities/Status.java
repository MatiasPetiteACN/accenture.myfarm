package com.spring.accenture.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
//esta entity declara los detalles de una granja.
	//se le pone el dinero como medida para avanzar un MVP
	
	//declaro los campos necesarios
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	
	@Column
	private double money;
	
	@Column
	private String size;
	
	@Column
	private String locationID;
	
	

	//getters y setters
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public long getID() {
		return ID;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String newSize) {
		size = newSize;
	}
	
	
	
	
}
