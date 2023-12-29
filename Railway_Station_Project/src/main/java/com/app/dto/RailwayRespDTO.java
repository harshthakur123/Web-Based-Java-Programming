package com.app.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.app.entities.Category;
import com.app.entities.Station;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RailwayRespDTO {

	@NotBlank
	private String name;

	private Category category;

	private String startTime;

	private String endTime;

	private String source;

	private String destination;
	
	private List<Station> stations;

}
