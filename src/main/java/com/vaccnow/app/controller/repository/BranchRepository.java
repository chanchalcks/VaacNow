package com.vaccnow.app.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccnow.app.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long>{

}



