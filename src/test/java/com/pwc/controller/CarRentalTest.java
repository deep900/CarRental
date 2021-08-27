package com.pwc.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CarRentalTest {

	@LocalServerPort
	private int serverPort;

	private RestTemplate restTemplate = new RestTemplate();

	private RentalDetails rentalDetails = new RentalDetails();

	private String URL = "http://localhost:";

	@BeforeTestExecution
	public void init() {		
		Car carForBooking = new Car("Honda", 300000.25, "Sedan");
		rentalDetails.setCarDetail(carForBooking);
		rentalDetails.setFromDate("30-08-2021");
		rentalDetails.setToDate("30-12-2021");
		rentalDetails.setBookingName("Alex");
		rentalDetails.setContactEmail("alex@myemail.com");
		rentalDetails.setContactNumber("+1 205-2568-250");
	}

	@Test
	public void carBookingTest() {
		HttpEntity<RentalDetails> request = new HttpEntity(rentalDetails);
		URL = URL + serverPort + "/rentCar";
		RentalDetails result = restTemplate.postForObject(URL, request, RentalDetails.class);
		Assert.assertEquals("booked", result.getBookingStatus());
	}
	
	@Test
	public void listCarTest(){
		URL = URL + serverPort + "/getCars";
		ResponseEntity response = restTemplate.getForEntity(URL,List.class);
		List carList = (List) response.getBody();
		System.out.println("Printing the cars list: " + carList);		
		Assert.assertNotNull(carList);
	}

}
