package com.dh.ts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.ts.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{

}
