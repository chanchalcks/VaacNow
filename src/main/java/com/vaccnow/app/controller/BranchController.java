package com.vaccnow.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.app.controller.service.BranchService;
import com.vaccnow.app.model.BranchResponseVo;
import com.vaccnow.app.model.BranchVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/branch")
@CrossOrigin("*")
public class BranchController {
	
	
	
	private BranchService branchService;
	
	@Autowired
	public BranchController(BranchService branchService)
	{
		
		this.branchService=branchService;		
		
	}
	
	
 @Operation(summary = "Add Branch")
 @ApiResponses(value = { 
 @ApiResponse(responseCode = "200", description = "Branch Added",content = { @Content(mediaType = "application/json")}),
 @ApiResponse(responseCode = "400", description = "Invalid Syntex",content = @Content)})
 @PostMapping(value="/api/v1/add",produces ="application/json")
  public BranchResponseVo add(@Valid @RequestBody BranchVo branchVo)
  {	  	  
	  return branchService.addBranch(branchVo);	  	     	  
  }
	
 
 @Operation(summary = "Update Branch")
 @ApiResponses(value = { 
 @ApiResponse(responseCode = "200", description = "Branch Updated",content = { @Content(mediaType = "application/json")}),
 @ApiResponse(responseCode = "400", description = "Invalid Syntex",content = @Content)})
 @PutMapping(value="/api/v1/update/{id}",produces ="application/json")
  public BranchResponseVo update(@PathVariable long id,@RequestBody BranchVo branchVo)
  {	  
	 return branchService.updateBranch(id, branchVo);		  	     	  
  }
  
 
 
 @Operation(summary = "Get All Branch")
 @ApiResponses(value = { 
 @ApiResponse(responseCode = "200", description = "Get All Branch",content = { @Content(mediaType = "application/json")})})
 @GetMapping(value="api/v1/getall",produces ="application/json")
   public List<String> fetchAllBranch()
   {
	   
	 
	 return branchService.getAllBranch();
	   
   }
 
 @Operation(summary = "Get All Branch Stock")
 @ApiResponses(value = { 
 @ApiResponse(responseCode = "200", description = "Get All Branch",content = { @Content(mediaType = "application/json")})})
 @GetMapping(value="api/v1/getall_branchstock",produces ="application/json")
   public List<BranchResponseVo> fetchAllBranchStock()
   {
	   
	 
	 return branchService.getAllBranchStock();
	   
   }
 
 
 
 
 
	
	
	

}
