package com.vaccnow.app;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vaccnow.app.controller.repository.BranchRepository;
import com.vaccnow.app.controller.service.BranchService;
import com.vaccnow.app.entity.Branch;
import com.vaccnow.app.model.BranchVo;


@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTest {
	
	@MockBean
	private BranchRepository branchRepository;

	@InjectMocks
	private BranchService branchService;
	
	@Test
	public void addBranchTest()
	{
//		Branch branch=new Branch();
//		branch.setId(1L);
//		BranchVo branchVo=new BranchVo();
//		  branchVo.setBranchName("MockBranch");		
//		Mockito.when(branchRepository.save(branch)).thenReturn(branch);		
//		branchService.addBranch(branchVo);
	}
}
