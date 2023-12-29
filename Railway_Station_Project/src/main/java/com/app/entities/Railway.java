package com.app.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true,exclude = "station")
public class Railway extends BaseEntity {

	@Column(length=20)
	private String name;
	@Enumerated(EnumType.STRING)
	private Category category;
	//@Column(nullable = false)
	private LocalTime startTime;
	//@Column(nullable = false)
	private LocalTime endTime;
	//@Column(length=20,nullable = false)
	private String source;
	//@Column(length=20,nullable = false)
	private String destination;
	
	@OneToMany(mappedBy = "railway",orphanRemoval = true,fetch=FetchType.EAGER)
	//Railway 1---->*Station
	@JsonIgnore
	private List<Station> station=new ArrayList<>();

	public Railway(String name, Category category, LocalTime startTime, LocalTime endTime, String source,
			String destination) {
		super();
		this.name = name;
		this.category = category;
		this.startTime = startTime;
		this.endTime = endTime;
		this.source = source;
		this.destination = destination;
	} 
	
	
	
}
