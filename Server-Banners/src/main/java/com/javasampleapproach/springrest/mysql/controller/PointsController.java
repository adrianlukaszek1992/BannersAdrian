package com.javasampleapproach.springrest.mysql.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.javasampleapproach.springrest.mysql.repo.PointsRepository;

import com.javasampleapproach.springrest.mysql.model.Points;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/point")

public class PointsController {

    @Autowired
    PointsRepository repository;

    @GetMapping("/list")
    public List<Points> getAllPoints() {
        System.out.println("Get all Points...");

        List<Points> point = new ArrayList<>();
        repository.findAll().forEach(point::add);

        return point;
    }


}
