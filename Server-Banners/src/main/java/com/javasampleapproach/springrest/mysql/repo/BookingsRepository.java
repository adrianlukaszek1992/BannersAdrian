package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.springrest.mysql.model.Bookings;

public interface BookingsRepository extends CrudRepository<Bookings, Long>{

    List<Bookings> findByStartDateGreaterThanEqualAndEndDateIsLessThanEqualAndPointNameEquals (String startDate, String endDate, String pointName);

}
