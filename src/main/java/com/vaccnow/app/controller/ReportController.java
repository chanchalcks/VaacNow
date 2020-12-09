package com.vaccnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.app.controller.service.VaccinationService;
import com.vaccnow.app.entity.Vaccination;

@RestController
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportController {
	
	
	
	private VaccinationService vaccinationService;
	
	@Autowired
	public ReportController(VaccinationService vaccinationService) {
		
		this.vaccinationService=vaccinationService;
		
	}
	
	
	@GetMapping("/api/v1/fetch_allvacanication_perbranch/{branchId}")
	public List<Vaccination> getAllVacanationPerBranch(@PathVariable long branchId)
	{
		return vaccinationService.getVaccinationPerBranch(branchId);
		
	}
	
	@GetMapping("/api/v1/fetch_allvacanication_betweenperiod/{date1}/{date2}")
	public List<Vaccination> getVaccanationBetweenTime(@PathVariable String date1,@PathVariable String date2)
	{
		return vaccinationService.getVaccanationBetweenDates(date1, date2);
	}
	
	
	
	

}
