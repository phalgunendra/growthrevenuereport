package com.capgemini.go;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import com.capgemini.go.entity.RevenueTable;


@SpringBootTest
public class SalesReportApplicationTests {

	@Test
	public void contextLoads() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

	    final String baseUrl = "http://localhost:" + 6242 + "/Reports/SalesReport/2017-05-20/2020-07-24/teja/electronics" ;
	    URI uri = new URI(baseUrl);

	    ResponseEntity<RevenueTable[]> datalist = restTemplate.getForEntity(uri, RevenueTable[].class);
	    RevenueTable[] data = datalist.getBody();
	    assertEquals(1, data.length);
	}

	@Test
	public void salesData() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

	    final String baseUrl = "http://localhost:" + 6242 + "/Reports/SalesReport/2017-05-20/2020-07-24/teja/electronics" ;
	    URI uri = new URI(baseUrl);

	    ResponseEntity<RevenueTable[]> datalist = restTemplate.getForEntity(uri, RevenueTable[].class);
	    RevenueTable[] data = datalist.getBody();
	    assertNotEquals(3, data.length);


	}


}