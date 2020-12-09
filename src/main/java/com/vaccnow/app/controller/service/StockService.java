package com.vaccnow.app.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.app.controller.repository.BranchRepository;
import com.vaccnow.app.entity.Branch;
import com.vaccnow.app.entity.VaccineStock;

@Service
public class StockService {
	
	private BranchRepository branchRepository;
	
	@Autowired
	public StockService(BranchRepository branchRepository)
	{
		this.branchRepository=branchRepository;
	}
	
	
	public void addStock(long branchId,int vaccineStock)
	{
		Branch branch=branchRepository.getOne(branchId);
		VaccineStock stock=new VaccineStock();
		branch.setStock(stock);
		branchRepository.save(branch);	
	}
	
	
	
	

}
