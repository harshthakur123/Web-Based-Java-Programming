package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Getter and setter are mandatory in DTO as spring call getters and setters 
//to fetch and save values to their respective fields 
//otherwise it will didnt show fields in swagger or postman
@Getter
@Setter
@ToString
public class StationRespDTO {

	@Column(nullable =false,unique = true)
	private String stationCode;

	@Column(nullable =false)
	private String stationName;

	@Positive(message = "Number of platforms should be positive")
	private int noOfPlatforms;
	
	

}
