package com.vaccnow.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VaccinationVo {
	
	
	private long branchId;
	
    private String timeSlot;
	
	private String paymentType;
	
	

}
