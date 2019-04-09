package com.javasampleapproach.springrest.mysql.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.springrest.mysql.model.Points;


public interface PointsRepository  extends CrudRepository<Points, Long>{



}
