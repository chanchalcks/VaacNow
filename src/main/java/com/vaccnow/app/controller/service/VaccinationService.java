package com.vaccnow.app.controller.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vaccnow.app.controller.repository.BranchRepository;
import com.vaccnow.app.controller.repository.VaccinationRepository;
import com.vaccnow.app.entity.Branch;
import com.vaccnow.app.entity.Vaccination;
import com.vaccnow.app.model.VaccinationVo;

@Service
public class VaccinationService {

	private BranchRepository branchRepository;
	
	private VaccinationRepository vaccanationRepository;
	

	public VaccinationService(BranchRepository branchRepository,
			                  VaccinationRepository vaccanationRepository) {

		this.branchRepository = branchRepository;
		this.vaccanationRepository=vaccanationRepository;
	}
	
	

	public Map<String, String> bookVacination(VaccinationVo vaccinationVo) {
		
		Map<String, String> message = new HashMap<>();
		Branch branch = branchRepository.getOne(vaccinationVo.getBranchId());
		Vaccination vaccination = Vaccination.builder()
				                  .paymentType(vaccinationVo.getPaymentType())
				                  .bookingDate(new Date())
				                  .timeSlot(vaccinationVo.getTimeSlot())
				                  .mailSent(true)
				                  .status("Applied").build();

		List<Vaccination> vacineList = new ArrayList<>();
		vacineList.add(vaccination);
		branch.setVaccinatation(vacineList);

		if (branchRepository.save(branch) != null) {

			message.put("message", "Time slot is booked");

		}
		return null;

	}
	

	public List<Vaccination> getVaccinationPerBranch(long branchId) {
		
		return branchRepository.getOne(branchId).getVaccinatation();
	}
	
	public List<Vaccination> getVaccanationBetweenDates(String date1,String date2)
	{
		return vaccanationRepository.findAllVaccinationBetweenPeriod(new Date(date1), new Date(date2));
	}

}
