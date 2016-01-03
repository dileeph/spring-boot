package com.dh.ts.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dh.ts.domain.Claim;
import com.dh.ts.repo.ClaimRepository;

@RestController
@RequestMapping(value = "/claims")
public class ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	@RequestMapping(value="/list",  method = RequestMethod.GET)
	@ResponseBody
	public List<Claim> listClaims(){
		return claimRepository.findAll();
	}
}
