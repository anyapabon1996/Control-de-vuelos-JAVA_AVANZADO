package com.session.three.fly.Fly.Service;

import com.session.three.fly.Fly.Model.Entity.Passenger;
import com.session.three.fly.Fly.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public void createPassenger(Passenger passenger){
        this.passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassanger(){
        return StreamSupport.stream(this.passengerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
