package com.pwc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

	@PostMapping(value = "/rentCar")
	public RentalDetails bookCar(@RequestBody RentalDetails rentalDetails) {
		System.out.println("Booking a car:" + rentalDetails);
		rentalDetails.setBookingStatus("booked");
		return rentalDetails;
	}

	@GetMapping(value = "/getCars")
	public @ResponseBody List<Car> getCars() {
		return getSampleCars();
	}

	private List<Car> getSampleCars() {
		List carList = new ArrayList();
		carList.add(new Car("Honda", 300000.25, "Sedan"));
		carList.add(new Car("Kia", 100400.25, "Mini"));
		carList.add(new Car("Hundai", 400400.25, "Sedan"));
		return carList;
	}
}
