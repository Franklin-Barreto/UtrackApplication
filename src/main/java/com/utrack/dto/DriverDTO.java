package com.utrack.dto;

public class DriverDTO {

	private int operNbr;
	private String carrierCd;
	private String lastName;
	private String first_name;
	private String middleInit;
	private int homeLoc6;
	private String homeLoc3;
	private String operClass;

	public DriverDTO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public DriverDTO(int operNbr, String carrierCd, String lastName, String
	 * first_name, String middleInit, int homeLoc6, String homeLoc3, String
	 * operClass) { super(); this.operNbr = operNbr; this.carrierCd = carrierCd;
	 * this.lastName = lastName; this.first_name = first_name; this.middleInit =
	 * middleInit; this.homeLoc6 = homeLoc6; this.homeLoc3 = homeLoc3;
	 * this.operClass = operClass; System.out.println("PORRA"); }
	 */

	public int getOperNbr() {
		return operNbr;
	}
	
	public void setOper_nbr(int operNbr) {
		this.operNbr = operNbr;
	}

	public String getCarrierCd() {
		return carrierCd;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLast_name(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirst_name(String firstName) {
		this.first_name = firstName;
	}

	public String getMiddleInit() {
		return middleInit;
	}

	public int getHomeLoc6() {
		return homeLoc6;
	}

	public String getHomeLoc3() {
		return homeLoc3;
	}

	public String getOperClass() {
		return operClass;
	}

}
