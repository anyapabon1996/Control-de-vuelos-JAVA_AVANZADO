package com.session.three.fly.Fly.Service;

import com.session.three.fly.Fly.Model.Entity.Fly;
import com.session.three.fly.Fly.Repository.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FlyService {

    @Autowired
    FlyRepository flyRepository;

    public Fly createNewFly(Fly fly){
        return this.flyRepository.save(fly);
    }

    public Fly getFlyByCode(String flyCode){
        return this.flyRepository.getFlyByCode(flyCode);
    }

    public Boolean changeDates(LocalDate departure, LocalDate arraving, String code){
         Fly fly = this.getFlyByCode(code);

         if (fly == null) {
             return false;
         } else {
             fly.setArraving(arraving);
             fly.setDeparture(departure);
             this.flyRepository.save(fly);
             return true;
         }
    }
}
