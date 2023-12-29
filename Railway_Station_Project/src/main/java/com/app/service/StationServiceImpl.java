package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundExceptions;
import com.app.dao.RailwayDao;
import com.app.dao.StationDao;
import com.app.dto.ApiResponse;
import com.app.dto.RailwayRespDTO;
import com.app.dto.StationRespDTO;
import com.app.entities.Railway;
import com.app.entities.Station;


@Service
@Transactional
public class StationServiceImpl implements StationService {

	@Autowired
    private	StationDao stationDao;
	
	@Autowired
	private RailwayService railwayService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RailwayDao railwayDao;

	@Override
	public Station addNewStation(StationRespDTO newStation,Long raiwayId) {
		System.out.println("in station service" + newStation);
		RailwayRespDTO railwayEn = railwayService.getRailwayById(raiwayId);
		Railway railway = mapper.map(railwayEn, Railway.class);
		railway = railwayDao.save(railway);
		//Station station = mapper.map(newStation, Station.class);
		Station station = new Station();
		station.setName(newStation.getStationName());
		station.setNo_of_platforms(newStation.getNoOfPlatforms());
		station.setStationCode(newStation.getStationCode());
		station.setRailway(railway);
		System.out.println("After mapping"+station);
		return stationDao.save(station);
		
		
	}

	@Override
	public String updatePlatforms(Long id, int platforms) {
		Station station = stationDao.findById(id).orElseThrow(()-> new ResourceNotFoundExceptions("Invalid station Id!!!"));
		
		station.setNo_of_platforms(platforms);
		
		return  "No of platforms updated";	
		}

	@Override
	public Station updateStation(Long id,StationRespDTO update) {
		Station map = mapper.map(update, Station.class);
		return stationDao.save(map);
		
	}


	


	


}
