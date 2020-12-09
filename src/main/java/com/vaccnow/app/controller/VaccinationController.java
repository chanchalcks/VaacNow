package com.vaccnow.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.app.controller.service.VaccinationService;
import com.vaccnow.app.model.VaccinationVo;

@RestController
@RequestMapping("/vaccine")
@CrossOrigin("*")
public class VaccinationController {
	
	
	
	private VaccinationService vaccinationService;
	
	@Autowired
	public VaccinationController()
	{
		this.vaccinationService=vaccinationService;
	}
	
	
	@PostMapping("/api/v1/book_timeslot")
	public Map<String,String> bookVaccination(@RequestBody VaccinationVo vaccinationVo)
	{
		
		return vaccinationService.bookVacination(vaccinationVo);
		
	}
	
	
	
	
	

}
