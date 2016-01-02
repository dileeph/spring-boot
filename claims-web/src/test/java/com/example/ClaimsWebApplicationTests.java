package com.example;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.util.UriComponentsBuilder;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClaimsWebApplication.class)
@WebAppConfiguration
public class ClaimsWebApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void uri_build_test(){
		URI uri = UriComponentsBuilder.newInstance().
		scheme("http").host("localhost").port("9090").path("/claims/list").build().toUri();
	
		Assert.assertTrue(uri.toString().equals("http://localhost:9090/claims/list"));
	}
}
