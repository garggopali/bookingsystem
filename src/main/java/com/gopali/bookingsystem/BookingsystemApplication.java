package com.gopali.bookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gopali.bookingsystem.controller.BookingController;

@SpringBootApplication
public class BookingsystemApplication {

	public static void main(String[] args) {

		//Tharading concept
		//BookingController bookingController=new  BookingController();
		//bookingController.getBookings();
		SpringApplication.run(BookingsystemApplication.class, args);
	}

}
