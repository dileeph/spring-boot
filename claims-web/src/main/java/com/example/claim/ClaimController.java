package com.example.claim;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/claim")
//@ConfigurationProperties(prefix="connection")
public class ClaimController {
	@Value("${connection.remoteAddress}")
	private String remoteAddress;
	@Value("${connection.port}")
	private String port;
	
	private URI uri = null;
	@PostConstruct
	public void init(){
		uri = UriComponentsBuilder.newInstance().scheme("http").host(remoteAddress).port(port).path("/claims/list").build().toUri();
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String messages(Model model) {
		
		List<Claim> claims = new ArrayList<>();
//		Calendar cal = Calendar.getInstance();
//		cal.set(2010, 10, 27);
//		claims.add(new Claim(1l,"256","A3330009", cal));
//		cal.set(2012, 11, 27);
//		claims.add(new Claim(1l,"454","C22204566", cal));
		
		RestTemplate restTemplate = new RestTemplate();
		
        try {
			ResponseEntity<List<Claim>> claimResponse = restTemplate.exchange(
					uri, 
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<Claim>>() {});
			if(claimResponse != null && claimResponse.hasBody()){
				claims = claimResponse.getBody();
			}
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        
	    model.addAttribute("claims", claims);//messageRepository.findAll());
	    return "claims-list";
	}
}
