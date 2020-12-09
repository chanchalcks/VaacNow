package com.vaccnow.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL)
public class BranchResponseVo {
	
	private long id;
	private String branchName;
	private int stock;
	private String message;
	
	public BranchResponseVo() {}
	
	public BranchResponseVo(long id,String branchName,int stock,String message)
	{
		this.id=id;
		this.branchName=branchName;
		this.stock=stock;
		this.message=message;
	}
	
	
	

}
