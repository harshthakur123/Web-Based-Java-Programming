package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.StationRespDTO;
import com.app.entities.Station;

public interface StationService {
	
	Station addNewStation(StationRespDTO station,Long railwayId);
	
	public String updatePlatforms(Long id,int platforms);
	
	public Station updateStation(Long id,StationRespDTO update);

	
	
}
