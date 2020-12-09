package com.vaccnow.app.controller.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.app.controller.repository.BranchRepository;
import com.vaccnow.app.entity.Branch;
import com.vaccnow.app.entity.VaccineStock;
import com.vaccnow.app.model.BranchResponseVo;
import com.vaccnow.app.model.BranchVo;
@Service
public class BranchService {
		
	
	private BranchRepository  branchRepository;
		
	@Autowired
	public BranchService(BranchRepository  branchRepository)
	{
		this.branchRepository=branchRepository;
	}

	
	public BranchResponseVo addBranch(BranchVo branchVo)
	{
		VaccineStock stock=VaccineStock.builder().stock(0).build();
		Branch branch=Branch.builder().name(branchVo.getBranchName()).stock(stock).build();	
		Branch savedBranch=branchRepository.save(branch);
		if(savedBranch!=null)
		{
			
			return BranchResponseVo.builder().id(savedBranch.getId())
					.branchName(savedBranch.getName())
					.message("Branch Updated Successfully")
					.build();
			
		}
		return null;
	}
	
	public BranchResponseVo updateBranch(long id,BranchVo branchVo)
	{
		Branch branch=Branch.builder().id(id).name(branchVo.getBranchName()).build();	
		Branch savedBranch=branchRepository.save(branch);
		if(savedBranch!=null)
		{
			return BranchResponseVo.builder().id(savedBranch.getId())
					.branchName(savedBranch.getName())
					.message("Branch Updated Successfully")
					.build();
			
		}
		return null;
	}
	
	
	public List<String> getAllBranch()
	{
		
		return branchRepository.findAll().stream().map(b->b.getName()).collect(Collectors.toList());
	}
	
	public List<BranchResponseVo> getAllBranchStock()
	{

		return branchRepository.findAll()
				.stream()
				.map(b->new BranchResponseVo(b.getId(),b.getName(),b.getStock().getStock(),null))			
				.collect(Collectors.toList());
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
