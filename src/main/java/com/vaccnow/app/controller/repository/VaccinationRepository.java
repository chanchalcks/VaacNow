package com.vaccnow.app.controller.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vaccnow.app.entity.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
	
	
	@Query("select a from Vaccination a where a.bookingDate <= :bookingDate1 and a.bookingDate >= :bookingDate2")
	List<Vaccination> findAllVaccinationBetweenPeriod( @Param("bookingDate1") Date bookingDate1,
			                                           @Param("bookingDate2") Date bookingDate2);

}
