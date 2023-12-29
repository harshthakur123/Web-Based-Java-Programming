package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.RailwayRespDTO;
import com.app.entities.Category;
import com.app.entities.Railway;

public interface RailwayService {
	
	String deleteRailwayDetails(Long Id);

	List<RailwayRespDTO> fecthAllRailwayByCategory(Category category);
	
	Railway addNewRailway(RailwayRespDTO railwayDTO);
	
	RailwayRespDTO getRailwayById(Long Id);
}
