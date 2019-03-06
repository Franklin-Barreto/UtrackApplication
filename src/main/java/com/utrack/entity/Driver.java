package com.utrack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver {

	@Id
	private Integer id;
	private Integer version;
	private Integer driverId;
	private String firstName;
	private String middleInit;
	private String lastName;
	private String operClass;
	//private Carrier carrier;
	//private Location location;

	public Driver(Integer driverId, String firstName, String middleInit, String lastName, String operClass,
			Carrier carrier, Location location) {
		this.driverId = driverId;
		this.firstName = firstName;
		this.middleInit = middleInit;
		this.lastName = lastName;
		this.operClass = operClass;
	//	this.carrier = carrier;
	//	this.location = location;
	}
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getId() {
		return id;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleInit() {
		return middleInit;
	}

	public String getLastName() {
		return lastName;
	}

	public String getOperClass() {
		return operClass;
	}

	/*public Carrier getCarrier() {
		return carrier;
	}

	public Location getLocation() {
		return location;
	}*/

}
