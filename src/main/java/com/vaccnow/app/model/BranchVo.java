package com.vaccnow.app.model;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchVo {
	
	
	
	@NotNull
    @Size(min=1, message = "Branch Name can not be blank or null")
	private String branchName;
	
	
	
	

}
