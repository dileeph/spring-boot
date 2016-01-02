package com.cts.ts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ts.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{

}
