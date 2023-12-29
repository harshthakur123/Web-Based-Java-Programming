package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true,exclude = "railway")
public class Station extends BaseEntity {

	@Column(length=20)
	private String stationCode;
	@Column(length=20)
	private String name;
//	@Column(nullable = false)
	private int no_of_platforms;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	//Railway *--->1 Station
	
	private Railway railway;

	public Station(String stationCode, String name, int no_of_platforms) {
		super();
		this.stationCode = stationCode;
		this.name = name;
		this.no_of_platforms = no_of_platforms;
	}
	
	
	
}
