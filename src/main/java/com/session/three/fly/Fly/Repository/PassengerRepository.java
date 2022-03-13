package com.session.three.fly.Fly.Repository;

import com.session.three.fly.Fly.Model.Entity.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
}
