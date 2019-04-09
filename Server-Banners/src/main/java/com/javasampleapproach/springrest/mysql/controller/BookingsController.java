package com.javasampleapproach.springrest.mysql.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.javasampleapproach.springrest.mysql.repo.BookingsRepository;

import com.javasampleapproach.springrest.mysql.model.Bookings;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingsController {

    @Autowired
    BookingsRepository repository;

    @GetMapping("/validation")
    public boolean validation (@RequestParam  String startDate, String endDate, String pointName) {

        System.out.println("Doing validation...");
        List<Bookings> booking = repository.findByStartDateGreaterThanEqualAndEndDateIsLessThanEqualAndPointNameEquals(startDate, endDate, pointName);
        boolean validation;

        if (booking.size() == 0) {
            validation=true;
        }
        else{
            validation=false;
        }
        return validation;
    }


    @PostMapping(value = "/create")
    public Bookings postCustomer(@RequestBody Bookings booking) {



        if (validation(booking.getStartDate(), booking.getEndDate(), booking.getPointName())==true) {
            Bookings _booking = repository.save(new Bookings(booking.getName(), booking.getLastname(), booking.getEmail(), booking.getStartDate(), booking.getEndDate(), booking.getPointName()));
            System.out.println(booking.getName());
            return _booking;

        } else {
            return null;
        }
    }

}
