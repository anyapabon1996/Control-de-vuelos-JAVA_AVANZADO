package com.session.three.fly.Fly.Service;

import com.session.three.fly.Fly.Model.Entity.Airplane;
import com.session.three.fly.Fly.Repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    public Airplane createAirplane(Airplane airplane){
        return this.airplaneRepository.save(airplane);
    }

    public Airplane findAirplaneByName(String name){
        return this.airplaneRepository.getAirplaneByName(name);
    }
}
