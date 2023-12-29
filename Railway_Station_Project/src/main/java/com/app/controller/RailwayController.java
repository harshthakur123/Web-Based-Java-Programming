package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.RailwayRespDTO;
import com.app.entities.Category;
import com.app.entities.Railway;
import com.app.service.RailwayService;



@RestController
@RequestMapping("/railways")
public class RailwayController {

	
	@Autowired
	private RailwayService railwayService;

	public RailwayController() {
		System.out.println("In ctor of "+getClass());
	}
	

	//URL: localhost:8080/railway/railway_id
	//method : DELETE
	//resp : APIrepsp body
	@DeleteMapping("/{railway_id}")
	//@Pathvariable --> data binding from incoming URI to method argument
	public ApiResponse deleteRailwayDetails(@PathVariable Long railway_id){
		return new ApiResponse(railwayService.deleteRailwayDetails(railway_id));
	}
	
	//URL : localhost:8080/railway/category
	//method : GET
	//resp : apiRespBody
	@GetMapping("/category/{cat}")
	public List<RailwayRespDTO> getAllRailwayByCategory(@PathVariable Category cat){
		return railwayService.fecthAllRailwayByCategory(cat);
		
	}
	
	
	//URL : localhost:8080/railway/
	//method : POST
	//resp : detached railway entity
	@PostMapping("/addNewRailway")
	public Railway addNewRailway(@RequestBody RailwayRespDTO newRailway)// Take request body from springframework
	// not from io-swagger , i stucked in it for 3 hours, unmarshalling did'nt happen, and even if you insert data
	//in request body it will show null in response body(de-ser not happening) dont trust STS too much, use your own intellisense
	{
		//@RequestBody --> method arg level annnotation for unmarshalling 
		//de-ser (json->java obj) done by jackson vendor
		System.out.println(newRailway);
		
		return railwayService.addNewRailway(newRailway);
		
		
	}
	
	@GetMapping("/{id}")
	public RailwayRespDTO getRailwayId(@PathVariable long id) {
		
		return railwayService.getRailwayById(id);
	}
	
	
	
	
	
}
